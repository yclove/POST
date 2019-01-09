package com.ycengine.post.main

import android.support.v4.view.PagerAdapter
import android.view.View
import com.ycengine.post.data.model.PostModel

/**
 * YCNOTE : FragmentPagerAdapter 와 FragmentStatePagerAdapter
 *
 * Fragment 를 처리하는 PagerAdapter 는 두 가지 Class 가 존재한다.
 * 하나는 FragmentPagerAdapter 이고 다른 하나는 FragmentStatePagerAdapter 이다.
 * FragmentPagerAdapter 의 경우, 사용자가 ViewPager 에서 좌/우로 스크롤(플링)하여 화면 전환을 하여 다음 Fragment 가 표시되면 이전 Fragment 를 메모리 상에 저장해 만일 사용자가 화면을 반대로 이동하면 메모리 상에 저장되어있는 Fragment 를 사용하게된다.
 * 2번째 FragmentStatePagerAdapter 는 ViewPager 의 페이지를 이동하여 다음 Fragment 가 표시되면 이전 Fragment 는 메모리 상에서 제거된다.
 * 사용자가 화면을 다시 반대로 전환하면 기존에 저장된 상태값(state)을 기반으로 재생성합니다.
 * 그러므로 페이지 수가 정해져 있고 그 수가 많지 않다면 FragmentPagerAdapter 를 사용하는 편이 좋고 반대로 페이지 수를 알 수 없거나 많다면 FragmentStatePagerAdapter 를 사용하는 것이 좋다.
 */

/**
 * YCNOTE : PagerAdapter notifyDataSetChanged
 *
 * PagerAdapter 에 대한 notifyDataSetChanged()는 오직 ViewPager 에게 data set 이 변경되었다는 사실만을 알려준다.
 * ViewPager 는 view 의 등록과 삭제를 getItemPosition( Object ) 과 getCount() 를 통해 한다.
 * notifyDataSetChanged() 가 불리면 ViewPager 는 child view 의 position 을 getItemPosition( Object ) 을 호출하여 알아본다.
 * 만약 이 child view 가 POSITION_NONE 을 던지면 ViewPager 는 view 가 삭제되었음을 안다.
 * 그리고 destroyItem( ViewGroup, int, Object )을 불러 이 view 를 제거한다.
 * ViewPager 가 View 를 업데이트하지 않는 현상이 나타나면 다음과 같이 억지로 update 시킬 수 있다.
 * <p/>
 * 1. PagerAdapter 의 getItemPosition( Object object ) 를 override 하고 여기서 POSITION_NONE 값을 return 한다.
 * 저 값은 -2로, 저 값이 들어가면 ViewPager 는 notifyDataSetChanged() 가 불릴 때마다 모든 View 를 다시 그린다.
 * 따라서 효율성이 떨어지긴 하지만 어쨌든 해결은 된다. 권장할만한 방법은 아니다.
 * <p/>
 * 2. setTag() 를 통해 Fragment 에 tag 를 매겨놓고, PagerAdapter 의 instantiateItem( View, position ) 을 override 하여 tag 값 기준으로 필요한 view 만 다시 생성한다.
 * 이 방법을 이용하면 notifyDataSetChanged() 를 부르지 않고, ViewPager.findViewWithTag( Object ) 를 통해서 update 를 시도해야 한다.
 */
class PostAdapter: PagerAdapter() {

    private var mItems = arrayListOf<PostModel>()

    // instantiateItem() 메소드에서 리턴된 Object 가 View 가  맞는지 확인하는 메소드
    override fun isViewFromObject(v: View, obj: Any): Boolean {
        return v == obj
    }

    override fun getCount(): Int {
        return mItems.size
    }
}