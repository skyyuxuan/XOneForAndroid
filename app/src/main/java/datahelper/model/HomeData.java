package datahelper.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by j-xuanyu on 2015/12/10.
 */
public class HomeData extends DataModelBase {

    public class HomeDataItem {
        public String WebLink;
        public String LastUpdateDate;
        public String MarketTime;
        public String DayDiffer;
        public String ID;
        public String Author;
        public String Content;
        public String OriginalImgUrl;
        public String ThumbnailUrl;
        public String Pn;
        public String WebImgUrl;
        public String Title;
    }

    public List<HomeDataItem> HomeDataItems;

    @Override
    public void Parse(String str) {
        HomeDataItems = new ArrayList<HomeDataItem>();
        try {
            JSONObject jsonObject = new JSONObject(str);
            JSONObject root = jsonObject.getJSONObject("hpAdMulitEntity");
            JSONArray jsonArray = root.getJSONArray("lstEntHp");

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jo = jsonArray.getJSONObject(i);
                HomeDataItem item = new HomeDataItem();
                item.WebLink = jo.getString("sWebLk");
                item.LastUpdateDate = jo.getString("strLastUpdateDate");
                item.MarketTime = jo.getString("strMarketTime");
                item.DayDiffer = jo.getString("strDayDiffer");
                item.ID = jo.getString("strHpId");
                item.Author = jo.getString("strAuthor");
                item.Content = jo.getString("strContent");
                item.OriginalImgUrl = jo.getString("strOriginalImgUrl");
                item.ThumbnailUrl = jo.getString("strThumbnailUrl");
                item.Pn = jo.getString("strPn");
                item.WebImgUrl = jo.getString("sWebLk");
                item.Title = jo.getString("strHpTitle");
                HomeDataItems.add(item);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
