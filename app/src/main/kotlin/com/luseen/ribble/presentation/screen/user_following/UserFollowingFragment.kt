package com.luseen.ribble.presentation.screen.user_following


import android.support.v7.widget.GridLayoutManager
import com.luseen.ribble.R
import com.luseen.ribble.domain.entity.Shot
import com.luseen.ribble.presentation.adapter.ShotRecyclerViewAdapter
import com.luseen.ribble.presentation.adapter.listener.ShotClickListener
import com.luseen.ribble.presentation.base_mvp.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_shot.*
import javax.inject.Inject


class UserFollowingFragment : BaseFragment<UserFollowingContract.View, UserFollowingContract.Presenter>(),
        UserFollowingContract.View, ShotClickListener {

    @Inject
    protected lateinit var followingPresenter: UserFollowPresenter

    private var recyclerAdapter: ShotRecyclerViewAdapter? = null

    override fun injectDependencies() {
        activityComponent.inject(this)
    }

    override fun layoutResId() = R.layout.fragment_user_following

    override fun initPresenter() = followingPresenter

    override fun onShotClicked(shot: Shot) {

    }

    override fun showLoading() {

    }

    override fun hideLoading() {

    }

    override fun showError() {

    }

    override fun onShotListReceive(shotList: List<Shot>) {
        updateAdapter(shotList)
    }

    private fun updateAdapter(shotList: List<Shot>) {
        recyclerAdapter?.update(shotList) ?: this setUpRecyclerView shotList
    }

    private infix fun setUpRecyclerView(shotList: List<Shot>) {
        recyclerAdapter = ShotRecyclerViewAdapter(shotList, this)
        shotRecyclerView.layoutManager = GridLayoutManager(activity, 2)
        shotRecyclerView.adapter = recyclerAdapter
    }
}