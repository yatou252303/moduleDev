package com.component.constant;

/**
 * Created by weichyang on 2017/6/26.
 */

public class ConstanPool {

    /**
     * 常量池
     */
    public static final String TYPE_SIGN = "sign";
    public static final String TYPE_LOGIN = "login";
    public static final String TYPE_RESET = "resetPwd";
    public static final String TYPE_UPDATE = "updatePwd";

    //记事本
    public static final String P_CATEGORYLIST = "categorylist";
    public static final String P_CATEGORY = "category";
    public static final String P_CURRENTSELECTEDTAB = "currentSelectedTab";

    public static final String P_NOTEBOOK = "notebook";
    public static final String P_INDEX = "index"; //选择项目

    public static final String P_TYPE_INPUT = "2"; //收入 1支出
    public static final String P_TYPE_OUTPUT = "1"; //收入 1支出


    public static final String BUNDLE = "bundle";

    public static final String P_AID = "aid";
    public static final String P_DES = "describe";
    public static final int REQUEST_CODE = 100;

    public static final String P_PARAMTER = "p_paramter";
    public static final String CONFIG_FIRSTLOGIN = "is_first_login";
    public static final String SPLASH_IMAGE_URL = "splash_image_url";
    public static final String SHOW_TIME = "show_time";
    public static final int FORWARD_GROUND = 1; //前台
    public static final String SCHEDULE_REFRESH_ACTION = "schedule_refresh_action"; //定时刷新
    public static final int TEXT_LENTH = 16;
    public static final String ISEDITER = "isediter";
    public static final int CODE_UPDATE = 1001;
    public static final int RESULT_DATA_OUTPUT = 1002; //数据输出
    public static final String LOCAL_OFF = "local_swtich"; //本地開關

    //登录类型
    public static final int SMS_LOGIN = 0;
    public static final int PHONE_LOGIN = 1;
    public static final int WEIXIN_LOGIN = 2;
    public static final int QQ_LOGIN = 3;
    public static final int SINA_LOGIN = 4;


    //记账类型
    public static int RECORDER_TYPE_INPUT = 1;
    public static int RECORDER_TYPE_OUTPUT = 2;

    //账本分类

//    推送类型

    public static final String PUSH_MSG = "pushMsg";//推送自定义消息体
    public static final String IS_PUSH_FROM = "isFromPush";//是否来自推送的initent
    public static final String UM_DEVICE = "umeng_device_token";


    //webview
    public static final String WEB_IS_COOKIE = "isneedCookie";
    public static final String WEB_IS_PARAMS = "isneedPARAMS";
    public static final String WEB_IS_COLSE = "isCanClose";
    public static final String WEB_URL = "weburl";
    public static final String WEB_TITLE = "webTitle";
    public static final String WEB_FINISH_STARTMAIN = "web_finish_startmain";
    public static final String WEB_LOGIN_TYPE = "webLogin";
    public static final String WEB_KEY = "web_key";// webtitle key-value
    public static final int WEBKEY_PARAMS = -1;//webView需要url参数
    /**
     * boolean类型 t=开启，f=关闭
     */
    public static final String WEB_BTN_RIGHT = "web_btn_right";//是否开启webview标题栏 右菜单按钮
    /**
     * 点击事件类型
     */
    public static final String WEB_BTN_RIGHT_CLICK_TYPE = "web_btn_right_click_type";
    /**
     * //关闭当前页
     */
    public static final int WEB_BTN_CLICK_TYPE_FINISH = 1;
    /**
     * //打开新activity，暂不支持webActivity
     */
    public static final int WEB_BTN_CLICK_TYPE_STARTACT = 2;
    public static final String WEB_BTN_RIGHT_TITLE = "web_btn_right_title";
    /**
     * 打开新页面的activityclass参数
     */
    public static final String WEB_BTN_RIGHT_CLASS_ACT = "web_btn_right_intent";
    /**
     * 给right_btn传递的bundle
     */
    public static final String WEB_BTN_RIGHT_BUNDLE = "web_btn_right_bundle";

    public static final String From_Data = "fromData";

    public static final String MAILTO = "mailto";

    public static final String BUDGET_SWITCH = "budget_switch"; //预约设置开关
    public static final String BUDGET_SWITCH_AID = "budget_switch_aid"; //给具体账本设置aid

    public static final String BUDGET_AMOUNT = "budget_amount"; //预算金额

    public static int KEEP_TO_DB = 1; //保存到本地
    public static int NOT_KEEP_TO_DB = 0; //默认

    //查询类别
    public static int QUERY_MONTH = 0; //查询月
    public static int QUERY_YEAR = 1; //查询年
    public static int QUERY_ALL = 2; //查询全部

    public static final String LOGIN_FLAG = "login_flag";


    //推送相关
    public static final int CHANNEL_ID_INT = 19900129;
    public static final String CHANNEL_ID_STRING = "19900129";
}
