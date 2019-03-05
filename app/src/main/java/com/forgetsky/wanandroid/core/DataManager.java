package com.forgetsky.wanandroid.core;

import com.forgetsky.wanandroid.core.db.DbHelper;
import com.forgetsky.wanandroid.core.greendao.HistoryData;
import com.forgetsky.wanandroid.core.http.BaseResponse;
import com.forgetsky.wanandroid.core.http.HttpHelper;
import com.forgetsky.wanandroid.modules.homepager.banner.BannerData;
import com.forgetsky.wanandroid.modules.homepager.bean.ArticleItemData;
import com.forgetsky.wanandroid.modules.homepager.bean.ArticleListData;
import com.forgetsky.wanandroid.modules.login.bean.LoginData;
import com.forgetsky.wanandroid.modules.main.bean.TopSearchData;
import com.forgetsky.wanandroid.modules.main.bean.UsefulSiteData;

import java.util.List;

import io.reactivex.Observable;

public class DataManager implements HttpHelper, DbHelper {
    private HttpHelper mHttpHelper;
    private DbHelper mDbHelper;

    public DataManager(HttpHelper httpHelper, DbHelper dbHelper) {
        mHttpHelper = httpHelper;
        mDbHelper = dbHelper;
    }

    @Override
    public Observable<BaseResponse<ArticleListData>> getArticleList(int pageNum) {
        return mHttpHelper.getArticleList(pageNum);
    }

    @Override
    public Observable<BaseResponse<List<BannerData>>> getBannerData() {
        return mHttpHelper.getBannerData();
    }

    @Override
    public Observable<BaseResponse<List<ArticleItemData>>> getTopArticles() {
        return mHttpHelper.getTopArticles();
    }

    @Override
    public Observable<BaseResponse<List<UsefulSiteData>>> getUsefulSites() {
        return mHttpHelper.getUsefulSites();
    }

    @Override
    public Observable<BaseResponse<List<TopSearchData>>> getTopSearchData() {
        return mHttpHelper.getTopSearchData();
    }

    @Override
    public Observable<BaseResponse<ArticleListData>> getSearchResultList(int pageNum, String k) {
        return mHttpHelper.getSearchResultList(pageNum, k);
    }

    @Override
    public Observable<BaseResponse<LoginData>> login(String username, String password) {
        return mHttpHelper.login(username, password);
    }

    @Override
    public Observable<BaseResponse<LoginData>> register(String username, String password, String repassword) {
        return mHttpHelper.register(username, password, repassword);
    }

    @Override
    public Observable<BaseResponse<LoginData>> logout() {
        return mHttpHelper.logout();
    }

    @Override
    public List<HistoryData> addHistoryData(String data) {
        return mDbHelper.addHistoryData(data);
    }

    @Override
    public void clearAllHistoryData() {
        mDbHelper.clearAllHistoryData();
    }

    @Override
    public void deleteHistoryDataById(Long id) {
        mDbHelper.deleteHistoryDataById(id);
    }

    @Override
    public List<HistoryData> loadAllHistoryData() {
        return mDbHelper.loadAllHistoryData();
    }
}
