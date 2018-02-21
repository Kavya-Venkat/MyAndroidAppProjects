using System;
using System.Web.Services;
using System.Collections.Generic;
//using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using DataTableConverter;
using System.Data;
using System.Configuration;
using MySql.Data.MySqlClient;
using System.Text;
using System.Security.Cryptography;

public partial class members_idcards : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {
		DoSecurityCheck();
		string newcd=GenerateQSLCode();
		Response.Write(newcd);
		
        string conn = ConfigurationManager.ConnectionStrings["DB_CONNECTION"].ConnectionString;

        string sql = @"SELECT 
            s.Samiti AS `Samiti Name`
            , sm.state AS `State`
            , s.dist_cd AS `District Code`
            , IFNULL(s.createdby,'System') As 'Created By' 
            , IF(s.createdon, DATE_FORMAT(s.createdon,'%m-%d-%Y'), '--') as `Created On`
            FROM samitis s 
            JOIN statemaster sm ON SUBSTR(s.dist_cd, 1,2) = sm.state";

		string distcd = Base64Decode(Request.QueryString["Distcd"]);
		
		if(distcd == "AIP") 
		{
			// national level login
			// no constrainst required
		}
		else if(distcd.IndexOf("state") > 0) 
		{
			// SP login
			distcd = Server.UrlDecode(distcd);
			sql += string.Format(" WHERE {0}", distcd);
		} 
		else 
		{
			// DP login
			sql += " WHERE s.dist_cd = @DistCD"; 
		}
		
        List<MySqlParameter> sqlParams = new List<MySqlParameter>();
        sqlParams.Add(new MySqlParameter("@DistCD", distcd));
        
        DataTableExecutor executor = new DataTableExecutor(Request, conn, sql, sqlParams);
		// Response.Write(distcd);
		//Response.Write(sql);
       // Response.Write(executor.ToDataTableResponse());
    }
	
	/*Public Function GenerateQSLCode(sPageName, sQueryString)
		salt = "Transf0rmingSelfT0Transf0rmTheW0rld"
		GenerateQSLCode = sha256(sPageName & sQueryString & salt)
	End Function*/
	[WebMethod]
	public static string GenerateQSLCode() {
		string pageName = "samiti.asp?members";//Request.Path.Substring(Request.Path.LastIndexOf("/"));
		//string qs = "samiti.asp?members";//Request.Path.Substring(Request.Path.LastIndexOf("/"));
		string output=pageName;
		Response.Write(output+"hiiii  ");
		//Request.QueryString.ToString();
		
		return sha256(pageName, pageName);
	}
	
	private static string sha256(string pageName, string qs)
    {
		string password = string.Format("Transf0rmingSelfT0Transf0rmTheW0rld{0}{1}", pageName, qs);
        SHA256Managed crypt = new SHA256Managed();
        string hash = String.Empty;
        byte[] crypto = crypt.ComputeHash(Encoding.ASCII.GetBytes(password), 0, Encoding.ASCII.GetByteCount(password));
        foreach (byte theByte in crypto)
        {
            hash += theByte.ToString("x2");
        }
		
        return hash;
    }	
	
	private void DoSecurityCheck()
    {
		/*if (Request.QueryString["qslc"] != GenerateQSLCode()) {
			Response.Write("<script>window.location.href='/login/login.asp';</script>");
		}*/
		
        if (Request.Cookies["Distcd"] == null)
        {
			//Response.Write("hello");
            //Response.Write("<script>window.location.href='/login/login.asp';</script>");
        }
    }

    private string Base64Decode(string encodedString)
    {
        byte[] data = Convert.FromBase64String(encodedString);
        return Encoding.UTF8.GetString(data);
    }
}