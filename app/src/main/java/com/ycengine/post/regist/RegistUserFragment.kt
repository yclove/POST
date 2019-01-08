package com.ycengine.post.regist

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.os.Message
import android.text.SpannableString
import android.text.Spanned
import android.text.method.LinkMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import com.ycengine.post.R
import com.ycengine.post.common.Constants
import com.ycengine.post.common.base.BaseFragment
import com.ycengine.post.databinding.FragmentRegistUserBinding
import com.ycengine.post.main.PostActivity
import com.ycengine.post.main.PostViewModel
import com.ycengine.post.util.CommonUtil
import com.ycengine.post.util.DeviceUtil
import com.ycengine.post.util.SPUtil
import com.ycengine.post.util.handler.IOnHandlerMessage
import com.ycengine.post.util.handler.WeakRefHandler
import com.ycengine.post.widget.PostDialog
import com.ycengine.post.widget.hashtaglink.AgreementTag
import kotlinx.android.synthetic.main.view_post_header.*
import okhttp3.MediaType
import okhttp3.RequestBody
import org.json.JSONObject
import timber.log.Timber
import java.util.regex.Matcher
import java.util.regex.Pattern

class RegistUserFragment : BaseFragment(), IOnHandlerMessage {

    companion object {
        fun newInstance(): RegistUserFragment {
            return RegistUserFragment()
        }
    }

    private val mHandler by lazy {
        WeakRefHandler(this)
    }

    private lateinit var binding: FragmentRegistUserBinding
    private lateinit var parentViewModel: PostViewModel
    private lateinit var viewModel: RegistUserViewModel

    private lateinit var mChoiceYearDialog: PostDialog
    private var mUserBirthYear: String = ""
    private var snsType: String = ""

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        activity?.let {
            parentViewModel = ViewModelProviders.of(it).get(PostViewModel::class.java)
        }

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_regist_user, container, false)
        binding.setLifecycleOwner(this)
        return binding.root
    }

    private fun initViewModel() {
        viewModel = ViewModelProviders
            .of(this)
            .get(RegistUserViewModel::class.java)

        viewModel.registUserModel.observe(this, Observer {
            it?.let { model ->
                SPUtil.setSharedPreference(context, Constants.SP_USER_ID, model.UAI)
                parentViewModel.userId.value = model.UAI
            }
        })
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initViewModel()

        setPostHeader(Constants.HEADER_TYPE_BACK_HOME, onClickListener)
        btnHeaderBack.visibility = View.GONE

        // 로고
        RotateAnimation(180f, 360f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f).apply {
            duration = 500
            repeatCount = Animation.INFINITE
        }.let {
            binding.ivRotate.startAnimation(it)
        }

        // 생년 및 성별 화면 > 태어난 해
        binding.tvUserBirthYearBtn.setOnClickListener {
            mChoiceYearDialog = PostDialog(context, Constants.DIALOG_TYPE_CHOICE_YEAR, onClickListener, mUserBirthYear)
            mChoiceYearDialog.show()
        }

        // 생년 및 성별 화면 > 성별 > 남
        binding.tgMaleBtn.setOnClickListener {
            binding.tgFemaleBtn.isChecked = !binding.tgMaleBtn.isChecked
            updateNextUI()
        }

        // 생년 및 성별 화면 > 성별 > 여
        binding.tgFemaleBtn.setOnClickListener {
            binding.tgMaleBtn.isChecked = !binding.tgFemaleBtn.isChecked
            updateNextUI()
        }

        // 생년 및 성별 화면 > 다음
        binding.llRegNextBtn.setOnClickListener {
            binding.llBirthYearGenderLayout.visibility = View.GONE
            binding.llWelcomeLayout.visibility = View.VISIBLE
            btnHeaderBack.visibility = View.VISIBLE
        }

        updateNextUI()

        // Welcome 화면
        binding.lstvWelcomeToPost.spacing = Constants.TEXT_VIEW_SPACING
        binding.lstvWelcomeToPost.text = getString(R.string.welcome_to_post)

        // Welcome 화면 > 시작하기
        binding.llRegActionBtn.setOnClickListener {
            if (chkeckData()) {
                val jsonObject = JSONObject()
                jsonObject.put("PUSH_ID", SPUtil.getSharedPreference(context, Constants.SP_PUSH_ID))
                jsonObject.put("BIRTHDATE", mUserBirthYear)
                jsonObject.put("GENDER", if (binding.tgMaleBtn.isChecked) "M" else "F")
                val body = RequestBody.create(MediaType.parse("${Constants.HEADER_CONTENT_TYPE_FORM}; charset=${Constants.SERVICE_CHAR_SET}"), "REQ_DATA=$jsonObject")
                viewModel.registUser(body)
            }
        }

        val usePattern: Pattern = Pattern.compile("이용약관,")
        val privatePattern: Pattern = Pattern.compile("개인정보보호정책,")
        val locationPattern: Pattern = Pattern.compile("위치정보이용약관")
        val useMatcher: Matcher = usePattern.matcher(binding.tvAgreeAllAgreement.text)
        val privateMatcher: Matcher = privatePattern.matcher(binding.tvAgreeAllAgreement.text)
        val locationMatcher: Matcher = locationPattern.matcher(binding.tvAgreeAllAgreement.text)

        val spannableString = SpannableString(binding.tvAgreeAllAgreement.text)
        while (useMatcher.find())
            spannableString.setSpan(
                AgreementTag(context, mHandler, "SERVICE"),
                useMatcher.start(),
                useMatcher.end(),
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
            )
        while (privateMatcher.find())
            spannableString.setSpan(
                AgreementTag(context, mHandler, "SCHEME"),
                privateMatcher.start(),
                privateMatcher.end(),
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
            )
        while (locationMatcher.find())
            spannableString.setSpan(
                AgreementTag(context, mHandler, "LOCATION"),
                locationMatcher.start(),
                locationMatcher.end(),
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
            )
        binding.tvAgreeAllAgreement.text = spannableString
        binding.tvAgreeAllAgreement.movementMethod = LinkMovementMethod.getInstance()

        updateConfirmUI()

        binding.llBirthYearGenderLayout.visibility = View.VISIBLE
        binding.llWelcomeLayout.visibility = View.GONE
        binding.llRestoreLayout.visibility = View.GONE
        btnHeaderBack.visibility = View.GONE
    }

    private fun updateNextUI() {
        if (CommonUtil.isNull(mUserBirthYear) || !binding.tgMaleBtn.isChecked && !binding.tgFemaleBtn.isChecked) {
            binding.llRegNextBtn.alpha = 0.2f
            binding.llRegNextBtn.isEnabled = false
        } else {
            binding.llRegNextBtn.alpha = 1.0f
            binding.llRegNextBtn.isEnabled = true
        }
    }

    private fun updateConfirmUI() {
        if (CommonUtil.isNull(snsType)) {
            binding.llRestoreConfirmBtn.alpha = 0.2f
            binding.llRestoreConfirmBtn.isEnabled = false
        } else {
            binding.llRestoreConfirmBtn.alpha = 1.0f
            binding.llRestoreConfirmBtn.isEnabled = true
        }
    }

    private fun chkeckData(): Boolean {
        var isResponse = true
        if (CommonUtil.isNull(mUserBirthYear)) {
            isResponse = false
            DeviceUtil.showToast(context, getString(R.string.required_birth_year))
        }
        return isResponse
    }

    private val onClickListener = View.OnClickListener {
        when (it.id) {
            // Header 뒤로가기 onClick
            R.id.btnHeaderBack -> {
                binding.llBirthYearGenderLayout.visibility = View.VISIBLE
                binding.llWelcomeLayout.visibility = View.GONE
                binding.llRestoreLayout.visibility = View.GONE
                btnHeaderBack.visibility = View.GONE
            }
            // 태어난 해 Dialog > 확인 onClick
            R.id.llSelectYearConfirmBtn -> {
                mChoiceYearDialog.apply {
                    dismiss()
                }
                mUserBirthYear = it.tag.toString()
                binding.tvUserBirthYear.text = mUserBirthYear
                binding.tvUserBirthYearBtn.alpha = 1.0f
                updateNextUI()
            }
            else -> {
                Timber.e("The request is else case. request : ${it.resources.getResourceEntryName(it.id)}")
            }
        }
    }

    override fun handleMessage(msg: Message?) {
        msg?.let {
            when (it.what) {
                // 동의 타입 별 onClick
                Constants.QUERY_AGREEMENT_DATA -> {
                    val agreementType: String? = it.data.getString("AGREEMENT_TYPE")
                    val intent = Intent(context, PostActivity::class.java) //AgreementServiceActivity
                    intent.putExtra("AGREEMENT_TYPE", agreementType)
                    startActivity(intent)
                }
            }
        }
    }
}