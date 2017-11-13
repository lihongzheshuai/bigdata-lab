package cn.rongcapital.bigdata.mr.test;

import cn.rongcapital.resume.mr.ResumeHTMLParser;
import cn.rongcapital.resume.mr.model.Resume;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author li.hzh 2017-11-13 11:17
 */
public class ResumeHTMLParserTest {

    private static final String resumeOne = "<head> <meta charset=\"UTF-8\"> " +
            "<meta http-equiv=\"X-UA-Compatible\" content=\"IE=7\"> <title>智联简历</title> " +
            "<link href=\"http://img00.zhaopin.cn/2012/css/rd/common.css\" rel=\"stylesheet\" type=\"text/css\"> " +
            "<link href=\"http://img00.zhaopin.cn/2012/css/rd/rdnew_2.css?version=20160421\" rel=\"stylesheet\" type=\"text/css\">" +
            " <link href=\"http://img00.zhaopin.cn/2012/css/rd/rdnewlayer.css\" rel=\"stylesheet\" type=\"text/css\"> " +
            "<link href=\"http://img00.zhaopin.cn/2012/css/ui/jquery.zlzp.popupdiv.css\" type=\"text/css\" rel=\"stylesheet\"> " +
            "<link href=\"http://img01.zhaopin.cn/2014/rd2/css/feedbackD.css?version=20160421\" type=\"text/css\" rel=\"stylesheet\"> " +
            "<link href=\"/css/sendinfo.css\" type=\"text/css\" rel=\"stylesheet\"> <style media=\"print\"> .resume-preview { color: #000; } ." +
            "resume-body-left { width: auto; } .resume-preview-left { box-shadow: none; border: none; } " +
            ".resume-preview-right, .nav-body-top { display: none; } h3 { border-bottom: 2px solid #ccc; } " +
            ".similar-resume { display: none; } </style></head><body> <div class=\"resume-preview clearfix\">" +
            " <style type=\"text/css\"> .posR { position: relative; border: 1px solid #ccc; height: 32px; } " +
            ".nameMatching, .nameMatchings { line-height: 32px; font-size: 12px; float: left; font-weight: normal; } " +
            ".nameMatching { margin-left: 28px; background: url(http://img02.zhaopin.cn/2012/img/rd/Pmatching.png) no-repeat 7px 7px; padding-left: 50px; height: 22px; padding-top: 10px; } .nameMatching .star { width: 50px; height: 9px; display: block; font-size: 0; background: url(http://img02.zhaopin.cn/2012/img/rd/matching-mark.png) no-repeat; } .nameMatching .star5 { background-position: 0 0; } .nameMatching .star4 { background-position: 0 -9px; } .nameMatching .star3 { background-position: 0 -18px; } .nameMatching .star2 { background-position: 0 -27px; } .nameMatching .star1 { background-position: 0 -36px; } .nameMatching .star0 { background-position: 0 -45px; } .nameMatchings { cursor: pointer; margin-left: 10px; background: url(http://img02.zhaopin.cn/2012/img/rd/Pcell.png) no-repeat 0 7px; height: 22px; width: 35px; } /*给我推荐更多相似人才 按钮*/ .acceptInvite { width: 100%; overflow: hidden; } .preview3 { float: left; } .preview3 span { font-size: 14px; } .moreRecom { float: left; width: 155px; height: 25px; background-color: #ff6600; border-radius: 3px; margin-left: 5px; margin-top: 25px; font: 12px/25px '微软雅黑'; color: #fff; text-align: center; cursor: pointer; } .fbtips { width: 748px; background-color: #fef8e0; line-height: 28px; border: 1px #eeebde solid; border-bottom: 1px #ffd138 solid; padding-left: 20px; font-size: 12px; color: #777; letter-spacing: 1px; height: 100%; overflow: hidden; } .fbtips span { float: left; } .fbtips span.textsty { color: #222; font-weight: bold; } .fbtips span.textstyone { color: #222; font-weight: bold; width: 180px; float: left; word-wrap: break-word; } #kp_num{display:none;} .printcontack{ display: none;width: 400px;margin-top: -80px;*margin-top:15px;}/*jianguo*/</style><style media=\"print\"> .noprint { display: none; } .feedbackE_show,.feedbackD_show{display: none;}/*jianguo*/ .printcontack{display: block;}/*jianguo*/ .preview-table-body-add{margin-top:-80px;*margin-top:0;}/*jianguo*/</style><script type=\"text/javascript\" async=\"\" src=\"http://img01.zhaopin.cn/2012/js/dywe.js\"></script><script type=\"text/javascript\"> function showMatchDesc(id, rootcompanyId, name) { $(\".MatchingDescriptionBtn\").match({ url: \"http://rd2.zhaopin.com/s/resuadmi/resumematchingdescription.asp\", type: \"Get\", data: { id: id, rootcompanyId: rootcompanyId, name: name }, callback: \"matchingcallback\" }); }</script><link type=\"text/css\" rel=\"stylesheet\" href=\"http://img00.zhaopin.cn/2012/css/rd/rdmatching.css\"><div class=\"resume-body-left\"><div class=\"resume-preview-head\" id=\"resumeContentHead\"> <img alt=\"\" src=\"http://img02.zhaopin.cn/2012/img/rd/logo.png\" width=\"133\" height=\"71\" align=\"right\" class=\"headerlogo\"> <div class=\"intro-span-right\"> 还有<span>387</span>份简历下载余额 </div> <input type=\"hidden\" name=\"resumeDownloadNum\" id=\"resumeDownloadNum\" value=\"1\"> <div class=\"resume-preview-title\"> <span class=\"resume-preview-list\">简历名称： <strong id=\"resumeName\">项目管理/项目协调 12年 长沙</strong></span> <br> <span class=\"resume-preview-list\">期望从事职业： <strong id=\"desireIndustry\">项目管理/项目协调、销售业务、销售管理</strong></span> <br> <span class=\"resume-preview-list\">简历更新时间： <strong id=\"resumeUpdateTime\">2015年09月06日</strong></span> </div> <div class=\"resume-preview-center\"> <div class=\"center-left\"> <div class=\"resume-left-tips\"> <div class=\"resume-left-tips-span\"> <span class=\"resume-left-tips-id\">ID: aJjMtNocv9iaO6Kj112IzA</span> </div> <div class=\"resume-left-tips-span tips-span-right\"> <span class=\"resume-left-tips-right\"><a href=\"http://rd2.zhaopin.com/s/resusech/searchUserResume.asp?um_id=aJjMtNocv9iaO6Kj112IzA\" target=\"_blank\">查看所有简历</a></span> </div> </div> </div> <!--<div class=\"center-right\">你可能对这些简历感兴趣</div>--> <input type=\"hidden\" value=\"Chinese\" name=\"language\" id=\"language\"> <input type=\"hidden\" value=\"Chinese\" name=\"anotherLanguage\" id=\"anotherLanguage\"> </div> <input type=\"hidden\" id=\"guid\" name=\"guid\" value=\"-1\"></div> <div id=\"resumeDetail\"> <div class=\"resume-preview-main\"> <div class=\"resume-preview-left\"> <div id=\"resumeContentBody\"><div class=\"resume-preview-main-title\"> <div class=\"main-title-fl fc6699cc\" style=\"height: 54px;\"> 个人信息 </div></div><div class=\"summary\"> <a target=\"_blank\" href=\"http://rd.zhaopin.com/img/lookResumes.jpg\"> <img alt=\"\" src=\"http://rd.zhaopin.com/img/lookResumes.jpg\" width=\"93\" height=\"131\" align=\"right\" class=\"headerImg\"></a> <div class=\"summary-top\"> <span>男    36岁(1980年7月)    13年工作经验    大专    已婚</span> <br> 现居住地：长沙 | 户口：长沙 | 团员 </div> <div class=\"summary-bottom\"> <!--普通简历显示联系方式--> <!--end显示联系方式--> <!--橄榄枝--> <!--end橄榄枝--> <div class=\"preview-table-body-add add_bgColor\">如需联系方式请下载该简历</div> <div class=\"preview-table-body-add preview1 noprint\" style=\"left: 250px; position: absolute;\"> <input type=\"button\" class=\"__ga__RecommendResume_jobinvite_004 Olive_send_btn\" id=\"jobinvited_select_posi\" value=\"发送橄榄枝\" name=\"jobinvited_select_posi\" style=\"height:52px;\" onclick=\"ZP.analysis.init_monitor_analy(this,'RecommendResume','jobinvite','004');;\"> </div> </div></div> <div class=\"resume-preview-all\"> <h3 class=\"fc6699cc\">求职意向</h3> <div class=\"resume-preview-top\"> <table cellpadding=\"0\" cellspacing=\"0\"> <tbody><tr valign=\"top\"> <td width=\"85\" align=\"right\">期望工作地区：</td> <td>长沙</td> </tr> <tr valign=\"top\"> <td width=\"85\" align=\"right\">期望月薪：</td> <td>10001-15000元/月</td> </tr> <tr valign=\"top\"> <td width=\"85\" align=\"right\">目前状况：</td> <td>我目前在职，正考虑换个新环境（如有合适的工作机会，到岗时间一个月左右）</td> </tr> <tr valign=\"top\"> <td width=\"85\" align=\"right\">期望工作性质：</td> <td>全职</td> </tr> <tr valign=\"top\"> <td width=\"85\" align=\"right\">期望从事职业：</td> <td>项目管理/项目协调、销售业务、销售管理</td> </tr> <tr valign=\"top\"> <td width=\"85\" align=\"right\">期望从事行业：</td> <td>房地产/建筑/建材/工程、大型设备/机电设备/重工业、仪器仪表及工业自动化、环保、农/林/牧/渔</td> </tr> </tbody></table> </div> </div> <div class=\"resume-preview-all\"> <h3 class=\"fc6699cc\">自我评价</h3> <div class=\"resume-preview-dl rd-break\">从事2年行政管理经验，有着2年渠道销售经验，对卖场，商超，小商品，代理商销售过程非常了解，有着9年的工程销售经验，对采购流程，招标流程熟悉，并有多次成功操作项目的经验。从2012年组建福州办事处，完成公司销售业绩，有管理团队的经验。 </div> </div> <div class=\"resume-preview-all workExperience\"> <h3 class=\"fc6699cc\">工作经历</h3> <h2>2009.09 - 至今  长沙巨星轻质建材股份有限公司  （7年）</h2> <h5>区域销售经理/主管 | 10001-15000元/月</h5> <div class=\"resume-preview-dl\"> 房地产/建筑/建材/工程 | 企业性质：民营 </div> <div class=\"resume-preview-dl\"> <table cellpadding=\"0\" cellspacing=\"0\"> <tbody><tr valign=\"top\"> <td width=\"60\">工作描述：</td> <td>工作职责： 负责巨星集团战略客户的开发，项目跟进及合同签定，回款，负责福州片区团队组建，项目工程业务开展 <br>工作业绩： 完成个人500万年销售指标，完成福州团队1000万销售指标，完成战略部5000万销售指标 </td> </tr> </tbody></table> </div> <h2>2006.04 - 2009.07  长沙海尔工贸  （3年3个月）</h2> <h5>销售经理 | 8001-10000元/月</h5> <div class=\"resume-preview-dl\"> 耐用消费品（服饰/纺织/皮革/家具/家电） | 企业性质：股份制企业 | 规模：10000人以上 </div> <div class=\"resume-preview-dl\"> <table cellpadding=\"0\" cellspacing=\"0\"> <tbody><tr valign=\"top\"> <td width=\"60\">工作描述：</td> <td>负责海尔集团旗下所有家电产品在湖南区域工程渠道销售，包括家电产品，小家电及中央空调的工程项目，主要工作内容是通过各种信息渠道收集工程项目信息，包括政府采购项目，参与投标。合同签订及货款回收。 </td> </tr> </tbody></table> </div> <h2>2004.03 - 2006.02  徐福记食品  （1年11个月）</h2> <h5>区域销售经理/主管 | 4001-6000元/月</h5> <div class=\"resume-preview-dl\"> 快速消费品（食品/饮料/烟酒/日化） | 企业性质：股份制企业 | 规模：10000人以上 </div> <div class=\"resume-preview-dl\"> <table cellpadding=\"0\" cellspacing=\"0\"> <tbody><tr valign=\"top\"> <td width=\"60\">工作描述：</td> <td>负责过嘉兴片区商超，卖场，小商品，负责过镇江片区商超，代理商，负责过淄博东营片区代理商，负责过上海片区小商品。 </td> </tr> </tbody></table> </div> <h2>2002.04 - 2004.03  徐福记食品  （1年11个月）</h2> <h5>行政经理/主管/办公室主任 | 2001-4000元/月</h5> <div class=\"resume-preview-dl\"> 快速消费品（食品/饮料/烟酒/日化） | 企业性质：股份制企业 | 规模：10000人以上 </div> <div class=\"resume-preview-dl\"> <table cellpadding=\"0\" cellspacing=\"0\"> <tbody><tr valign=\"top\"> <td width=\"60\">工作描述：</td> <td>负责西安分公司行政，采购，车辆管理，库房管理，人事管理，负责杭州分公司行政，采购，车辆管理，人事管理。后从杭州转嘉兴片区业务 </td> </tr> </tbody></table> </div> </div> <div class=\"resume-preview-all\"> <h3 class=\"fc6699cc\">教育经历</h3> <div class=\"resume-preview-dl educationContent\">1999.07 - 2002.07  湖南涉外经济学院  经济学  大专<br> </div> </div> <div class=\"resume-preview-all\"> <h3 class=\"fc6699cc\">简历内容</h3> <div class=\"resume-preview-dl\"> 许天风 男 <br> 目前公司： 长沙巨星轻质建材股份有限公司 <br> 目前职位： 战略部部长兼福州办事处主任 工作年限： 13年以上 <br> <br>基本资料 <br>年　　龄： 35 婚姻状况： 已婚 <br>手　　机： 13975806006 邮　　箱： 1473144992@qq.com <br>国　　籍： 中国 户　　籍： 长沙 <br>目前状态： 在职，急寻新工作 所在地点： 长沙-长沙县 <br><br>职业意向 <br>期望行业： 房地产开发/建筑/建材/工程 <br>期望职位： 区域销售经理 <br>期望地点： 长沙 <br>期望年薪： 面议 <br>目前年薪： 14.4 万 12,000 元 / 月 * 12 个月 <br><br>工作经历 <br>2009.09-至今 长沙巨星轻质建材股份有限公司 <br> 公司描述： http://search.51job.com/list/co,c,517202,000000,10,1.html<br><br><br>巨星集团成立于1995年6月，经过十多年来的发展，已经成为国内专业从事建筑新结构、新材料和新技术的国家级高新技术企业，湖南省建筑建材业的高新技术龙头企业和中国专利十佳企业，AAA级重合同、守信用单位。公司拥有各项专利7000多项。<br>巨星集团辖有长沙巨星轻质建材股份有限公司、湖南华廷筑邦建材有限公司、湖南省巨星建设有限公司、长沙金纳尔住宅设备有限公司四大体系等十多家独立法人企业，专门从事建筑新结构、新材料研究开发与推广应用，是中国空心结构领域的领袖企业。<br>巨星股份（长沙巨星轻质建材股份有限公司）已建立起科学高效的现代管理体系，下辖的“巨星结构新技术研究中心”、28个下属公司和驻外办事处等分支机构，以及工程、设计、业务、企划和知识产权等技术与市场核心部门，可以为客户提供优质全面服务。<br>巨星集团在长沙先导区、长沙国家高新技术开发区、宁乡经济技术开发区、娄底经济开... <br> <span class=\"keyword-highlight\">公司性质</span>： 私营·民营企业 <br> 公司规模： 2000-5000人 <br> 公司行业： 房地产开发/建筑/建材/工程 <br> 战略部部长兼福州办事处主任 2009.09-至今 <br> 薪酬状况： 12000 元 / 月 <br> 工作地点： 福州 <br> 所在部门： 战略客户部 <br> 汇报对象： 销售副总 <br> 下属人数： 9 <br> 工作职责： 负责巨星集团战略客户的开发，项目跟进及合同签定，回款，负责福州片区团队组建，项目工程业务开展 <br> 工作业绩： 完成个人800万年销售指标，完成福州团队2000万销售指标，完成战略部5000万销售指标 <br>2006.04-2009.07 海尔集团公司 <br> 公司描述： 海尔是全球大型家电第一品牌，1984年创立于青岛，现任董事局主席、首席执行官张瑞敏是海尔的主要创始人。目前，海尔在全球建立了21个工业园，5大研发中心，19个海外贸易公司，全球员工超过7万人。2011年，海尔集团全球营业额实现1509亿元，品牌价值962.8亿元，连续11年蝉联中国最有价值品牌榜首。海尔集团援建了164所希望小学和1所希望中学，制作212集科教动画片《海尔兄弟》，是2008年北京奥运会全球唯一白电赞助商。... <br> <span class=\"keyword-highlight\">公司性质</span>： 私营·民营企业 <br> 公司规模： 10000人以上 <br> 公司行业： 家具/家电 <br> 工程部项目经理 2006.04-2009.07 <br> 薪酬状况： 6000 元 / 月 <br> 工作地点： 长沙 <br> 所在部门： 工程销售部 <br> 汇报对象： 工程销售部部长 <br> 下属人数： 0 <br> 工作职责： 负责海尔集团旗下所有家电产品在湖南区域工程渠道销售，包括家电产品，小家电及中央空调的工程项目，主要工作内容是通过各种信息渠道收集工程项目信息，包括政府采购项目，参与投标。合同签订及货款回收。 <br>2002.04-2006.02 东莞徐记食品有限公司 <br> 公司描述： 徐福记国际控股集团有限公司 查看招聘中的职位>><br>公司行业： 快速消费品(食品、饮料、化妆品)<br><br><span class=\"keyword-highlight\">公司性质</span>： 外资(非欧美)<br><br>公司规模： 10000人以上<br><br>粉丝团(126)<br><br>徐福记简介<br><br>1.集团沿革<br>徐福记是由来自台湾的徐氏四兄弟于1992年在中国注册创立，结合16年成功的台湾市场销售经验，开拓新局，快速取得成长扩展。1997年新加坡汇亚集团加入徐福记营运行列，共同成立BVI徐福记国际集团，并注册成立东莞徐记食品有限公司，专门经营徐福记品牌在中国糖点领域的永续发展。2006年，徐福记在新加坡上市，迈向世界顶尖品牌的崭新里程碑。2011年，为实现企业永续经营与品牌百年的愿景，徐福记与雀巢携手合作。徐福记目前主要的生产基地坐落于东莞及河南，总占地面积超过50万平方米，拥有47个大型现代化车间，超过220多条一流自动化生产线，730多台尖端的包装设备。主要生产：糖果、糕点、沙琪玛、巧克力及果冻等糖点休闲食品，散、包装类超过1000多个款式。每日超过1400吨的产能，结合东莞生产基地所拥有超过2200个40呎货柜的自动化仓储物流调拨能力，以强大的效率充分供应市场，既使在旺季销售高峰期，依然货畅其流。徐福记产品畅销中国31个省、市、自治区，128个销售分公司的9000多名销售人员，经营及管理现代与传统渠道超过20000个直接掌控的终端零售点，快速及时地提供市场与消费需求的全面服务。品质稳定、安全美味的徐福记产品，屡获消费者评选为休闲食品满意度第一名的品牌。根据国家统计局年度统计调查：徐福记糖果从1998年至2011年已连续14年荣列全国同类产品销量第一名；06年获颁中国名牌饼干；07年持续获颁中国名牌糖果；2009年成为中国驰名商标。<br><br>2.产品研发<br>徐福记坚持创新与改良提升，以活泼的创新力，结合对市场趋势与消费习性的敏锐掌握度，每年汰旧换新平均推出30种以上的新品种及新口味，引导潮流﹑带动消费需求。研发团队长期深入研究华人生活习性与饮食文化特点，研制推出多样化的特色产品，从品种到口味都有独特的华人特色与风味，满足中国人日常生活里，讲究变化、而且喜欢尝新挑鲜的特殊饮食习性，让徐福记... <br> <span class=\"keyword-highlight\">公司性质</span>： 中外合营(合资·合作) <br> 公司规模： 10000人以上 <br> 公司行业： 食品/饮料/烟酒/日化 <br> 区域销售经理 2004.03-2006.02 <br> 工作地点： 南京 <br> 下属人数： 0 <br> 工作职责： 负责过嘉兴片区商超，卖场，小商品，负责过镇江片区商超，代理商，负责过淄博东营片区代理商，负责过上海片区小商品。 <br> 行政主管 2002.04-2004.03 <br> 工作地点： 杭州 <br> 下属人数： 0 <br> 工作职责： 负责西安分公司行政，采购，车辆管理，库房管理，人事管理，负责杭州分公司行政，采购，车辆管理，人事管理。后从杭州转嘉兴片区业务 <br><br>教育经历 <br>湖南涉外经济学院（ 1999.09 - 2002.07 ） <br>专业名称： 经济信息管理 学历： 大专 是否统招： 否 <br><br>语言能力 <br>普通话 <br><br>项目经历 <br>某房地产集团项目 2010.04-2010.11 <br>项目职务： 战略部客户经理 <br>项目描述： 某房地产项目采购空心楼盖产品 <br>项目职责： 负责该项目信息收集，与甲方沟通产品使用在项目上的经济优势或功能优势，使甲方认可我司技术，与设计院沟通技术的可行性，说服设计师配合，待双方达成一致后配合出施工图。出图后与施工单位沟通采购产品。 <br>项目业绩： 该房地产集团公司在郑州一个项目上两栋塔楼使用我司产品，项目金额600多万，后该集团在福州两个超高层标杆项目使用我司产品，分别为500多万及700多万项目金额。 <br>某酒店电视冰箱采购项目 2006.06-2006.07 <br>项目职务： 工程部客户经理 <br>项目描述： 某酒店360间房的海尔电视，海尔小冰箱采购，与之沟通销售海尔产品 <br>项目职责： 第一次独立负责项目，从项目信息收集，到与客户沟通真正需求，到了解竞争对手情况，标书参数的沟通，然制作标书商务及技术内容，答疑。 <br>项目业绩： 完成该项目采购，成功中标，项目金额200多万 <br><br>自我评价 <br>从事2年行政管理经验，有着2年渠道销售经验，对卖场，商超，小商品，代理商销售过程非常了解，有着9年的工程销售经验，对采购流程，招标流程熟悉，并有多次成功操作项目的经验。从2012年组建福州办事处，完成公司销售业绩，有管理团队的经验。 <br><br>附加信息 <br>多次获得公司优秀员工奖，销售精英奖 </div> </div> <div class=\"previewLayer11 rd_button smpevent\" data-smpaction=\"downloadresume\" data-smpposition=\"resumedetail\"></div> </div><div class=\"resume-preview-right\"> <div class=\"resume-preview-button previewLayer11 smpevent\" data-smpaction=\"downloadresume\" data-smpposition=\"resumedetail\"> <span class=\"resume-preview-button-span preview-icon11\"></span>下载简历 </div> <div class=\"resume-preview-button previewLayer12 smpevent\" data-smpaction=\"savetemporaryresume\" data-smpposition=\"resumedetail\"> <span class=\"resume-preview-button-span preview-icon12\"></span>暂存简历 </div> <div class=\"resume-preview-button previewLayer8 smpevent\" data-smpaction=\"printresume\" data-smpposition=\"resumedetail\"> <span class=\"resume-preview-button-span preview-icon8\"></span>打印简历 </div> <div class=\"resume-preview-button previewLayer1 smpevent\" data-smpaction=\"savetocomputer\" data-smpposition=\"resumedetail\"> <span class=\"resume-preview-button-span preview-icon1\"></span>保存到我的电脑 </div> <div class=\"resume-preview-button previewLayer2 smpevent\" data-smpaction=\"forwardemail\" data-smpposition=\"resumedetail\"> <span class=\"resume-preview-button-span preview-icon2\"></span>转发简历到邮箱 </div> <a class=\"previewLayer_xsjl similar-button\" style=\"display: none\" target=\"_blank\" href=\"http://rdsearch.zhaopin.com/similarresume/seemore?resumeID=232774978&resumeName=%E9%A1%B9%E7%9B%AE%E7%AE%A1%E7%90%86%2F%E9%A1%B9%E7%9B%AE%E5%8D%8F%E8%B0%83%2012%E5%B9%B4%20%E9%95%BF%E6%B2%99\"> <span class=\"preview-icon_xsjl resume-preview-button-span preview-icon-similar\"></span> <span id=\"xsjl_count\" class=\"similar-decoration\">相似简历(7)</span> <span class=\"new-icon\"></span> </a> <!--<div class=\"resume-preview-button previewLayer10\"><span class=\"resume-preview-button-span preview-icon10\"></span>返回顶部</div>--></div><div class=\"back-to\" style=\"display: none;\"></div><div class=\"szmr_over\"> <div class=\"szmr_overts\"> <div id=\"subWindowMain\" class=\"tanchuang_main\"> </div> </div></div><div id=\"downfile\" style=\"display: none\"></div> </div> </div> </div> <input type=\"hidden\" value=\"AppId=1&Id=656490086&Timestamp=636087142258605960&Callback=&signature=1fbf21feb9d61c30bbaa4d2adf7b3167&comid=61946902&comname=四川投资宝金融外包服务有限公司\" id=\"neturlparam\"> <!--随手聘--> <input type=\"hidden\" name=\"posttype\" id=\"posttype\" value=\"0\"> <input type=\"hidden\" name=\"labeltype\" id=\"labeltype\" value=\"0\"> <input type=\"hidden\" name=\"positionid\" id=\"positionid\" value=\"0\"> <!--反馈通D期--> <input type=\"hidden\" name=\"tt_username\" id=\"tt_username\" value=\"许天风\"> <input type=\"hidden\" name=\"tt_sourceid\" id=\"tt_sourceid\" value=\"3\"> <input type=\"hidden\" name=\"resume_id\" id=\"resume_id\" value=\"232774978\"> <input type=\"hidden\" name=\"extId\" id=\"extId\" value=\"aJjMtNocv9iaO6Kj112IzA\"> <input type=\"hidden\" name=\"resume_version\" id=\"resume_version\" value=\"1\"> <input type=\"hidden\" name=\"resume_language\" id=\"resume_language\" value=\"1\"> <input type=\"hidden\" name=\"resume_Name\" id=\"resume_Name\" value=\"项目管理/项目协调 12年 长沙\"> <input type=\"hidden\" name=\"resumeUserId\" id=\"resumeUserId\" value=\"656490086\"> <input type=\"hidden\" name=\"currentCompanyName\" id=\"currentCompanyName\" value=\"四川投资宝金融外包服务有限公司\"> <input type=\"hidden\" name=\"currentDepartmentName\" value=\"四川投资宝金融外包服务有限公司\"> <input type=\"hidden\" name=\"PositionNumber\" id=\"PositionNumber\" value=\"\"> <input type=\"hidden\" name=\"gltype\" id=\"gltype\" value=\"0\"> <input type=\"hidden\" name=\"GlStatus\" id=\"GlStatus\" value=\"0\"> <input type=\"hidden\" name=\"ApplyResume\" id=\"ApplyResume\" value=\"\"> <input type=\"hidden\" name=\"rootCompanyId\" id=\"rootCompanyId\" value=\"61946902\"> <!-- Trace Data Block Start --> <input type=\"hidden\" name=\"dda_kpi\" id=\"dda_kpi\" value=\"M1\"> <input type=\"hidden\" name=\"dda_operatorid\" id=\"dda_operatorid\" value=\"202323774\"> <input type=\"hidden\" name=\"dda_companyid\" id=\"dda_companyid\" value=\"61946902\"> <input type=\"hidden\" name=\"dda_custom\" id=\"dda_custom\" value=\"\"> <input type=\"hidden\" name=\"dda_ownerid\" id=\"dda_ownerid\" value=\"\"> <input type=\"hidden\" name=\"dda_cvid\" id=\"dda_cvid\" value=\"aJjMtNocv9iaO6Kj112IzA_1\"> <input type=\"hidden\" name=\"dda_position\" id=\"dda_position\" value=\"resumedetail\"> <input type=\"hidden\" name=\"dda_action\" id=\"dda_action\" value=\"viewdetail\"> <input type=\"hidden\" name=\"dda_xtable\" id=\"dda_xtable\" value=\"\"> <input type=\"hidden\" name=\"dda_type\" id=\"dda_type\" value=\"cvdownload\"> <!-- Trace Data Block End --> <input type=\"hidden\" name=\"rewardhrresult\" id=\"rewardhrresult\" value=\"0\" data-reward=\"5\"> <a id=\"fileLink\" href=\"\" style=\"display: none\"></a> <div class=\"moreTalented noprint\" style=\"display: none;\" id=\"kp_panel\"> <p class=\"mtTitle\">更多靠谱人才</p> <div class=\"mtChatCon\"> <ul></ul> </div> <div class=\"mtCheckAll\"><a target=\"_blank\" href=\"#\" id=\"kp_linkall\" class=\"__ga__JobInviteLU_clickViewAll$CV_001\">查看全部>></a></div> </div> <div id=\"smilarresume\" class=\"similar-resume\" style=\"\"> <h1>相似简历</h1> <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\"> <thead> <tr> <td nowrap=\"\">简历名称</td> <td nowrap=\"\" width=\"135\">职位名称</td> <td nowrap=\"\" width=\"30\">学历</td> <td nowrap=\"\" width=\"30\">性别</td> <td nowrap=\"\" width=\"30\">年龄</td> <td nowrap=\"\" width=\"70\">期望月薪</td> <td nowrap=\"\" width=\"30\">状态</td> <td nowrap=\"\" width=\"60\">现居住地</td> <td nowrap=\"\" class=\"similar-td-padding\" width=\"68\">更新时间</td> </tr> </thead> <tbody id=\"sr_tobdy\"><tr valign=\"top\"><td><div class=\"thead-white fc315\"><a href=\"http://rd.zhaopin.com/resumepreview/resume/viewone/2/Eblc76c4mOO0gm2xe)nfeg_1_1?simlarresume=2&resumeviewfrom=1&t=1473088626&k=5A5C9382008784CD9D477D2FFE84838D\" target=\"_blank\" title=\"区域销售经理/主管 7年 湖南\">区域销售经理/主管 7年 湖南</a></div></td><td><span title=\"区域销售经理/主管\">区域销售经理/主管</span></td><td>大专</td><td>男</td><td>29</td><td>面议</td><td>离职</td><td><span title=\"长沙\">长沙</span></td><td class=\"similar-td-padding\">16-08-12</td></tr><tr valign=\"top\"><td><div class=\"thead-white fc315\"><a href=\"http://rd.zhaopin.com/resumepreview/resume/viewone/2/2oq9IV6LqByaO6Kj112IzA_1_1?simlarresume=2&resumeviewfrom=1&t=1473088626&k=FE7D1FC1B2E4300812FA681949A54748\" target=\"_blank\" title=\"区域销售经理/主管 12年 \">区域销售经理/主管 12年 </a></div></td><td><span title=\"区域销售经理/主管\">区域销售经理/主管</span></td><td>本科</td><td>男</td><td>36</td><td>面议</td><td>离职</td><td><span title=\"长沙\">长沙</span></td><td class=\"similar-td-padding\">16-09-04</td></tr><tr valign=\"top\"><td><div class=\"thead-white fc315\"><a href=\"http://rd.zhaopin.com/resumepreview/resume/viewone/2/hWPOwSPlXymaO6Kj112IzA_1_1?simlarresume=2&resumeviewfrom=1&t=1473088626&k=CA509B24F24465A797ED76A5F2203C1E\" target=\"_blank\" title=\"区域销售经理/主管 6年 长沙\">区域销售经理/主管 6年 长沙</a></div></td><td><span title=\"区域销售经理/主管\">区域销售经理/主管</span></td><td>大专</td><td>男</td><td>32</td><td>6001-8000</td><td>离职</td><td><span title=\"长沙\">长沙</span></td><td class=\"similar-td-padding\">16-06-26</td></tr><tr valign=\"top\"><td><div class=\"thead-white fc315\"><a href=\"http://rd.zhaopin.com/resumepreview/resume/viewone/2/NdznUdxm1WGaO6Kj112IzA_1_1?simlarresume=2&resumeviewfrom=1&t=1473088626&k=E3D1DD901777CD6D0A090D776E7F2DBC\" target=\"_blank\" title=\"区域销售经理/主管 4年 湖南\">区域销售经理/主管 4年 湖南</a></div></td><td><span title=\"区域销售经理/主管\">区域销售经理/主管</span></td><td>大专</td><td>男</td><td>27</td><td>4001-6000</td><td>离职</td><td><span title=\"长沙\">长沙</span></td><td class=\"similar-td-padding\">16-07-06</td></tr><tr valign=\"top\"><td><div class=\"thead-white fc315\"><a href=\"http://rd.zhaopin.com/resumepreview/resume/viewone/2/)rFHQDqUG6aaO6Kj112IzA_1_1?simlarresume=2&resumeviewfrom=1&t=1473088626&k=7C259575D0276C9940A2FA6357D0D25D\" target=\"_blank\" title=\"区域销售经理/主管 12年 长沙\">区域销售经理/主管 12年 长沙</a></div></td><td><span title=\"区域销售经理/主管\">区域销售经理/主管</span></td><td>本科</td><td>女</td><td>36</td><td>8001-10000</td><td>离职</td><td><span title=\"长沙\">长沙</span></td><td class=\"similar-td-padding\">16-07-10</td></tr><tr valign=\"top\"><td><div class=\"thead-white fc315\"><a href=\"http://rd.zhaopin.com/resumepreview/resume/viewone/2/siqkDZ2vbVaaO6Kj112IzA_1_1?simlarresume=2&resumeviewfrom=1&t=1473088626&k=AA45433AAE64808B9F1DE82D4C5F8D18\" target=\"_blank\" title=\"区域销售经理/主管 4年 长沙\">区域销售经理/主管 4年 长沙</a></div></td><td><span title=\"区域销售经理/主管\">区域销售经理/主管</span></td><td>本科</td><td>男</td><td>27</td><td>10001-15000</td><td>在职</td><td><span title=\"长沙\">长沙</span></td><td class=\"similar-td-padding\">16-06-29</td></tr><tr valign=\"top\" class=\"last-bottom\"><td><div class=\"thead-white fc315\"><a href=\"http://rd.zhaopin.com/resumepreview/resume/viewone/2/VaBslz5pkwOaO6Kj112IzA_1_1?simlarresume=2&resumeviewfrom=1&t=1473088626&k=178A0323ABB2D201AEECAAE2C958E72A\" target=\"_blank\" title=\"区域销售经理/主管 12年 湖南\">区域销售经理/主管 12年 湖南</a></div></td><td><span title=\"区域销售经理/主管\">区域销售经理/主管</span></td><td>大专</td><td>男</td><td>35</td><td>6001-8000</td><td>离职</td><td><span title=\"长沙\">长沙</span></td><td class=\"similar-td-padding\">16-07-27</td></tr></tbody> <tfoot> <tr> <td colspan=\"10\"> <div class=\"satisfaction-ul\"> <span>您对“相似简历”的功能是否满意？</span> <span id=\"smilarResumeFeedback\"><a class=\"satisfaction-yes\" href=\"javascript:void(0);\">满意</a><a class=\"satisfaction-no\" href=\"javascript:void(0)\">不满意</a></span> </div> </td> </tr> </tfoot> </table> </div> <script type=\"text/javascript\" language=\"javascript\"> if (typeof (jobTitleInit) != 'undefined') { jobTitleInit(); } if (typeof (countKPJL) != 'undefined') { countKPJL(); } if (typeof (getKPJL) != 'undefined') { getKPJL(); } function switchlang(lang) { $('#changeLanguageImg').show(); var href = location.href.replace(/&?lang=\\w*/, ''); if (href.indexOf('?') == -1) { location.href = href + '?lang=' + lang; } else if (href.lastIndexOf('?') == href.length - 1) { location.href = href + 'lang=' + lang; } else { location.href = href + '&lang=' + lang; } } </script></div><input type=\"hidden\" name=\"viewSource\" id=\"viewSource\" value=\"2\"><input type=\"hidden\" name=\"keyword_search\" id=\"keyword_search\" value=\"公司性质\"><input type=\"hidden\" name=\"college_search\" id=\"college_search\" value=\"\"><input type=\"hidden\" name=\"company_search\" id=\"company_search\" value=\"\"><input type=\"hidden\" name=\"dda_source\" id=\"dda_source\" value=\"2\"> </div> <div class=\"editor-layer-add\"> <div class=\"editor-layer-icon cvLabelColor1 dev_label_icon_list\" dev_classname=\"cvLabelColor1\"> </div> <div class=\"editor-layer-icon cvLabelColor2 dev_label_icon_list\" dev_classname=\"cvLabelColor2\"> </div> <div class=\"editor-layer-icon cvLabelColor3 dev_label_icon_list\" dev_classname=\"cvLabelColor3\"> </div> <div class=\"editor-layer-icon cvLabelColor4 dev_label_icon_list\" dev_classname=\"cvLabelColor4\"> </div> <div class=\"editor-layer-icon cvLabelColor5 dev_label_icon_list\" dev_classname=\"cvLabelColor5\"> </div> <div class=\"editor-layer-icon cvLabelColor6 dev_label_icon_list\" dev_classname=\"cvLabelColor6\"> </div> <div class=\"editor-layer-icon cvLabelColor7 dev_label_icon_list\" dev_classname=\"cvLabelColor7\"> </div> <div class=\"editor-layer-icon cvLabelColor8 dev_label_icon_list\" dev_classname=\"cvLabelColor8\"> </div> <div class=\"editor-layer-icon cvLabelColor9 dev_label_icon_list\" dev_classname=\"cvLabelColor9\"> </div> <div class=\"editor-layer-icon cvLabelColor10 dev_label_icon_list\" dev_classname=\"cvLabelColor10\"> </div> <div class=\"editor-layer-icon cvLabelColor11 dev_label_icon_list\" dev_classname=\"cvLabelColor11\"> </div> <div class=\"editor-layer-icon cvLabelColor12 dev_label_icon_list\" dev_classname=\"cvLabelColor12\"> </div> </div> <script type=\"text/javascript\" src=\"http://img01.zhaopin.cn/2012/js/jquery-1.6.4.min.js\"></script> <!--script type=\"text/javascript\" src=\"http://img01.zhaopin.cn/2012/js/arrdata.js\"></script--> <script type=\"text/javascript\" src=\"http://img01.zhaopin.cn/2012/js/zlzp.app.js\"></script> <script type=\"text/javascript\" src=\"http://img01.zhaopin.cn/2012/js/rd/jquery.unobtrusive-ajax.min.js\"></script> <script type=\"text/javascript\" src=\"http://img01.zhaopin.cn/2012/js/ui/jquery.zlzp.popupdiv.js\"></script> <script type=\"text/javascript\" src=\"http://img01.zhaopin.cn/2012/js/ui/jquery.zlzp.popupbase.js\"></script> <script type=\"text/javascript\" src=\"http://img01.zhaopin.cn/2012/js/rd/common.js\"></script> <script type=\"text/javascript\" src=\"http://img01.zhaopin.cn/2012/js/rd/utilscript.js\"></script> <script type=\"text/javascript\" src=\"http://img01.zhaopin.cn/2012/js/rd/fnresuadmi.js\"></script> <script type=\"text/javascript\" src=\"http://img01.zhaopin.cn/2012/js/ui/jquery.zlzp.autocomplete.js\"></script> <script type=\"text/javascript\" src=\"http://img01.zhaopin.cn/2012/js/za/smp.min.js\"></script> <script type=\"text/javascript\" src=\"http://img01.zhaopin.cn/2012/js/rd/previewlayer.js?version=20160624\"></script> <script type=\"text/javascript\" src=\"http://img01.zhaopin.cn/2014/rd2/js/fktResumeActive.js\"></script> <!--反馈通D期--> <script type=\"text/javascript\" src=\"http://img01.zhaopin.cn/2014/common/js/jquery.cookie.js\"></script> <script type=\"text/javascript\" src=\"http://img01.zhaopin.cn/2014/rd2/js/feedbackD.js?version=20160421\"></script> <script type=\"text/javascript\" src=\"http://img00.zpin.net.cn/2014/common/js/za/ga_rd.js\"></script> <script src=\"http://img07.zpin.net.cn/2014/rd2/js/timecountdown.min.js\" type=\"text/javascript\"></script> <script type=\"text/javascript\" src=\"http://img08.zpin.net.cn/2014/rd2/js/rob_time.js\"></script> </body>";

    @Test
    public void testParse() {
        Resume resume = new ResumeHTMLParser().parse(resumeOne);
        Assert.assertNotNull(resume);
        Assert.assertEquals("智联简历", resume.getSource());
    }

}
