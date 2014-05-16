package com.openrdf.utils;

/**
 * EmailTemp工具类，用来组装所需的Email
 * 
 * @description 本程序用于来自谢先斌毕业论文，如有使用请联系作 者，注明出处。
 * @URL 代码地址：http://github.com/openRDF/rdf_fronts
 * @rdf com.openrdf.utils
 * @dateTime 2014-2-27
 * @author XieXianbin
 * @email a.b@hotmail.com
 * 
 */
public class EmailTemp {

	// public static void main(String[] args) {
	// System.out.println(getRegisterEmailTemp("", "", "").replace("'", "\""));
	// }
	public static String getRegisterEmailTemp(String userLoginEmail, String password,
			String configureUrl) {
		String emailBody = "<!DOCTYPE html PUBLIC '-//W3C//DTD XHTML 1.0 Transitional//EN' 'http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd'>                                                                                                 "
				+ "<html xmlns='http://www.w3.org/1999/xhtml'>                                                                                                                                                                               "
				+ "<head>                                                                                                                                                                                                                    "
				+ "    <meta http-equiv='Content-Type' content='text/html; charset=utf-8'>                                                                                                                                                   "
				+ "    <title>知识库系统邮箱验证</title>                                                                                                                                                                                     "
				+ "</head>                                                                                                                                                                                                                   "
				+ "<body>                                                                                                                                                                                                                    "
				+ "    <div style='border-bottom:3px solid #d9d9d9;width:900px;'>                                                                                                                                                            "
				+ "        <div style='border:1px solid #c8cfda;padding:40px;font-size:14px;'>                                                                                                                                               "
				+ "            <p>尊敬的用户：</p>                                                                                                                                                                                           "
				+ "            <p>&nbsp;&nbsp;&nbsp;&nbsp;您好！</p>                                                                                                                                                                         "
				+ "            <p>&nbsp;&nbsp;&nbsp;&nbsp;欢迎您知识库系统。您注册的邮箱是："
				+ userLoginEmail
				+ "，密码是："
				+ password
				+ "。点击以下链接确认注册。</p>                                                                                                        "
				+ "            <p></p>                                                                                                                                                                                                       "
				+ "            <p style='margin-left:30px;width:750px;word-wrap: break-word;'>                                                                                                                                                                                 "
				+ "                <a href='"
				+ configureUrl
				+ "'>"
				+ configureUrl
				+ "</a>                                                                                                                                                  "
				+ "            </p>                                                                                                                                                                                                          "
				+ "            <p></p>                                                                                                                                                                                                       "
				+ "            <br>                                                                                                                                                                                                          "
				+ "            <div style='border-top:1px solid #d9d9d9;padding:6px 0;font-size:12px;margin:6px 0 20px;text-align:center;'>                                                                                                  "
				+ "                <table cellspacing='0' cellpadding='0' border='0' align='center' style='font-size:12px;font-family:Helvetica Neue;border-collapse:collapse;width:600px;background-color:#ffffff;margin:auto;'>				"
				+ "                    <tbody>                                                                                                                                                                                               "
				+ "                        <tr>                                                                                                                                                                                              "
				+ "                            <td style='min-height:20px;padding:10px;'></td>                                                                                                                                               "
				+ "                        </tr>                                                                                                                                                                                             "
				+ "                        <tr>                                                                                                                                                                                              "
				+ "                            <td>                                                                                                                                                                                          "
				+ "                                <table cellspacing='0' cellpadding='0' border='0' style='text-align:center;'>                                                                                                             "
				+ "                                    <tbody>                                                                                                                                                                               "
				+ "                                        <tr>                                                                                                                                                                              "
				+ "                                            <td style='max-width:120px;padding:0 60px;'></td>                                                                                                                             "
				+ "                                            <td style='width:400px; height: 120px;margin:0;padding:0;'>                                                                                                                   "
				+ "                                                <p style='margin:0;padding:0;font-size:12px;color:#5e5e5e;text-align:left;line-height:14px;'>                                                                             "
				+ "                                                    <br>                                                                                                                                                                  "
				+ "                                                    本邮件由知识库系统系统自动发出，请勿直接回复！<br>                                                                                                                    "
				+ "                                                                                                                                                                                                                          "
				+ "                                                    <br>                                                                                                                                                                  "
				+ "                                                    <br>                                                                                                                                                                  "
				+ "                                                        新浪微博：                                                                                                                                                        "
				+ "                                                        <a href='http://weibo.com/hixxb' target='_blank'>                                                                                                                                "
				+ "                                                            http://weibo.com/hixxb                                                                                                                                      "
				+ "                                                        </a>                                                                                                                                                              "
				+ "                                                    <br>                                                                                                                                                                  "
				+ "                                                        新浪博客：                                                                                                                                                        "
				+ "                                                        <a href='http://blog.sina.com.cn/hixxb' target='_blank'>                                                                                                               "
				+ "                                                            http://blog.sina.com.cn/hixxb                                                                                                                                      "
				+ "                                                        </a>                                                                                                                                                              "
				+ "                                                </p>                                                                                                                                                                      "
				+ "                                            </td>                                                                                                                                                                         "
				+ "                                            <td style='max-width:80px;padding:0 40px;'></td>                                                                                                                              "
				+ "                                        </tr>                                                                                                                                                                             "
				+ "                                    </tbody>                                                                                                                                                                              "
				+ "                                </table>                                                                                                                                                                                  "
				+ "                            </td>                                                                                                                                                                                         "
				+ "                        </tr>                                                                                                                                                                                             "
				+ "                    </tbody>                                                                                                                                                                                              "
				+ "                </table>                                                                                                                                                                                                  "
				+ "            </div>                                                                                                                                                                                                        "
				+ "        </div>                                                                                                                                                                                                            "
				+ "    </div>                                                                                                                                                                                                                "
				+ "</body>                                                                                                                                                                                                                   "
				+ "</html>                                                                                                                                                                                                                   ";
		return emailBody.replace("'", "\"");
	}
}
