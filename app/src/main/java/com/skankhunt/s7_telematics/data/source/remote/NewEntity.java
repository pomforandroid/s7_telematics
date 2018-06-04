package com.skankhunt.s7_telematics.data.source.remote;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by wupengcong on 2018/6/4.
 */

public class NewEntity {
    @Override
    public String toString() {
        return "NewEntity{" +
                "error=" + error +
                ", results=" + results +
                '}';
    }

    /**
     * error : false
     * results : [{"_id":"5b10bce8421aa966feb27798","createdAt":"2018-06-01T11:26:32.532Z","desc":"基于react-natice实现的SmartRefreshLayout,可提供类似ios的弹性刷新、加载。","images":["http://img.gank.io/647c81bb-5bc0-4e7f-9d4e-d2ebfda9a3d2","http://img.gank.io/1023da2e-9727-464d-a389-542eef0c182b"],"publishedAt":"2018-06-04T00:00:00.0Z","source":"chrome","type":"Android","url":"https://github.com/react-native-studio/react-native-SmartRefreshLayout","used":true,"who":"lijinshanmx"},{"_id":"5b10d9be421aa91759d8b3e8","createdAt":"2018-06-01T13:29:34.68Z","desc":"Android App Bundle介绍","images":["http://img.gank.io/ac2cd1d4-92d4-4f52-9115-68572485a5d6"],"publishedAt":"2018-06-04T00:00:00.0Z","source":"web","type":"Android","url":"https://smallsoho.com/android/2018/05/28/AppBundle%E6%8E%A2%E7%B4%A2/","used":true,"who":"陈龙博"},{"_id":"5b13f5c1421aa93df569c6eb","createdAt":"2018-06-04T10:54:06.275Z","desc":"一个能自动进行压缩的小视频录制库。","images":["http://img.gank.io/b646fcbb-f43b-418f-bbe6-257a21504099"],"publishedAt":"2018-06-04T00:00:00.0Z","source":"chrome","type":"Android","url":"https://github.com/xuexiangjys/XVideo","used":true,"who":"xuexiangjys"},{"_id":"5b1400d3421aa93df85c428a","createdAt":"2018-06-03T22:53:07.182Z","desc":"做个抖音吧，自定义LayoutManager实现抖音效果","publishedAt":"2018-06-04T00:00:00.0Z","source":"web","type":"Android","url":"https://www.jianshu.com/p/34a0ef2d806d","used":true,"who":"DingMouRen"},{"_id":"5b14a370421aa93df85c428e","createdAt":"2018-06-04T10:26:56.185Z","desc":"一系列简单、轻量、方便的Android开发工具集合","publishedAt":"2018-06-04T00:00:00.0Z","source":"chrome","type":"Android","url":"https://github.com/yjfnypeu/EasyAndroid","used":true,"who":"lijinshanmx"},{"_id":"5b14a3d6421aa93df21e89e0","createdAt":"2018-06-04T10:53:01.797Z","desc":"一个完整的音乐播放器，以酷炫的用户界面和设计为动力。","images":["http://img.gank.io/481168d3-f5b8-4cbf-a975-bd905e8c61f6","http://img.gank.io/963d1a59-64ab-4e90-91a6-263344878e71","http://img.gank.io/9bf56e27-d2e6-4380-9030-dadd2da8818c","http://img.gank.io/1af7dc62-137f-48a6-9875-99bc77c69bd6","http://img.gank.io/bb78c564-aa8a-469b-ac59-9be956978d02"],"publishedAt":"2018-06-04T00:00:00.0Z","source":"chrome","type":"Android","url":"https://github.com/amangautam1/flutter-musicplayer","used":true,"who":"lijinshanmx"},{"_id":"5b14a3e8421aa93df21e89e1","createdAt":"2018-06-04T10:53:52.901Z","desc":"Android BaseDialog(开发必备)动画、加载进度、阴影、上下左右中、 进入等。","images":["http://img.gank.io/0ffb0100-f808-49fa-874d-a1ed2a50c3b6","http://img.gank.io/fa0a269c-03c2-4eb9-89ac-adae19f1779c","http://img.gank.io/b41e6b95-da0f-4b3b-8677-d35a2cd56f43","http://img.gank.io/adbdcb43-d2bb-4861-964b-8b9ba095d7dc","http://img.gank.io/6001d1a3-5c48-48dc-b9c6-345f47f6eb53"],"publishedAt":"2018-06-04T00:00:00.0Z","source":"chrome","type":"Android","url":"https://github.com/AnJiaoDe/BaseDialog","used":true,"who":"lijinshanmx"},{"_id":"5b14a443421aa93df85c428f","createdAt":"2018-06-04T10:53:24.0Z","desc":"用美丽的方式描述Android应用程序的持续时间。","images":["http://img.gank.io/04c548aa-b778-48ed-b159-ab9ab09ad394","http://img.gank.io/fa8a4e9d-9cf7-488f-b005-7f156ac561a3"],"publishedAt":"2018-06-04T00:00:00.0Z","source":"chrome","type":"Android","url":"https://github.com/rayzone107/DurationView","used":true,"who":"lijinshanmx"},{"_id":"5b14a68a421aa93df21e89e2","createdAt":"2018-06-04T11:19:59.938Z","desc":"PersonalAichatBot是基于人工智能的android ChatBot应用程序, 它还会让您自由选择您自己的默认问题和答案选项。","images":["http://img.gank.io/7f0cb2a0-7be2-459c-8d0e-da014de3522a"],"publishedAt":"2018-06-04T00:00:00.0Z","source":"chrome","type":"Android","url":"https://github.com/NAJMUS7834/PersonalAiChatBot","used":true,"who":"lijinshanmx"},{"_id":"5b14a6a8421aa93dfb2f416a","createdAt":"2018-06-04T10:53:39.55Z","desc":"React适用于Android + iOS的原生地理位置模块。","images":["http://img.gank.io/e37d82a0-facf-403d-a668-6bdbeffeceda"],"publishedAt":"2018-06-04T00:00:00.0Z","source":"chrome","type":"Android","url":"https://github.com/qiuxiang/react-native-amap-geolocation","used":true,"who":"lijinshanmx"}]
     */

    @SerializedName("error")
    private boolean error;
    @SerializedName("results")
    private List<ResultsBean> results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        @Override
        public String toString() {
            return "ResultsBean{" +
                    "id='" + id + '\'' +
                    ", createdAt='" + createdAt + '\'' +
                    ", desc='" + desc + '\'' +
                    ", publishedAt='" + publishedAt + '\'' +
                    ", source='" + source + '\'' +
                    ", type='" + type + '\'' +
                    ", url='" + url + '\'' +
                    ", used=" + used +
                    ", who='" + who + '\'' +
                    ", images=" + images +
                    '}';
        }

        /**
         * _id : 5b10bce8421aa966feb27798
         * createdAt : 2018-06-01T11:26:32.532Z
         * desc : 基于react-natice实现的SmartRefreshLayout,可提供类似ios的弹性刷新、加载。
         * images : ["http://img.gank.io/647c81bb-5bc0-4e7f-9d4e-d2ebfda9a3d2","http://img.gank.io/1023da2e-9727-464d-a389-542eef0c182b"]
         * publishedAt : 2018-06-04T00:00:00.0Z
         * source : chrome
         * type : Android
         * url : https://github.com/react-native-studio/react-native-SmartRefreshLayout
         * used : true
         * who : lijinshanmx
         */

        @SerializedName("_id")
        private String id;
        @SerializedName("createdAt")
        private String createdAt;
        @SerializedName("desc")
        private String desc;
        @SerializedName("publishedAt")
        private String publishedAt;
        @SerializedName("source")
        private String source;
        @SerializedName("type")
        private String type;
        @SerializedName("url")
        private String url;
        @SerializedName("used")
        private boolean used;
        @SerializedName("who")
        private String who;
        @SerializedName("images")
        private List<String> images;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getPublishedAt() {
            return publishedAt;
        }

        public void setPublishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public boolean isUsed() {
            return used;
        }

        public void setUsed(boolean used) {
            this.used = used;
        }

        public String getWho() {
            return who;
        }

        public void setWho(String who) {
            this.who = who;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }
}
