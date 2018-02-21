using DataTableConverter;
using MySql.Data.MySqlClient;
using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data;
using System.Text;

public partial class dashboard_datareport : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {
        string conn = ConfigurationManager.ConnectionStrings["DB_CONNECTION"].ConnectionString;
        string distcd = Base64Decode(Request.QueryString["Distcd"]);
        string cmd = Request.QueryString["cmd"] ?? string.Empty;
        string sql = string.Empty;

        if (distcd == "AIP")
        {
            // national level login
            sql = @"
            SELECT sm.state_name AS `State`
		        , COUNT(pd.sno) AS `Registered Total Members`
		        , SUM(IF(pd.sex = 1, 1, 0)) AS `Registered Males`
		        , SUM(IF(pd.sex = 0, 1, 0)) AS `Registered Females`
		        , SUM(CASE WHEN pd.mstatus = 'APPROVED' THEN 1 ELSE 0 END) AS `Total Approved`		
		        , SUM(CASE WHEN pd.sex= 1 AND pd.mstatus = 'APPROVED' THEN 1 ELSE 0 END) AS `Approved Males`
		        , SUM(CASE WHEN pd.sex= 0 AND pd.mstatus = 'APPROVED' THEN 1 ELSE 0 END) AS `Approved Females`		
		        , SUM(CASE WHEN pd.Guru_Balvikas = 1 AND pd.sex= 1 THEN 1 ELSE 0 END) AS `Balvikas Guru Males`	
				, SUM(CASE WHEN pd.Guru_Balvikas = 1 AND pd.sex= 0 THEN 1 ELSE 0 END) AS `Balvikas Guru Females`	
				, SUM(CASE WHEN pd.Stu_Balvikas = 1 AND pd.sex= 1 THEN 1 ELSE 0 END) AS `Balvikas Alumni Males`	
				, SUM(CASE WHEN pd.Stu_Balvikas = 1 AND pd.sex= 0 THEN 1 ELSE 0 END) AS `Balvikas Alumni Females`	
				, SUM(CASE WHEN pd.agerangeid > 5 AND pd.agerangeid < 8  AND pd.sex= 1 THEN 1 ELSE 0 END) AS `Sai Youth Males`	
				, SUM(CASE WHEN pd.agerangeid > 5 AND pd.agerangeid < 8  AND pd.sex= 0 THEN 1 ELSE 0 END) AS `Sai Youth Females`	
				, SUM(CASE WHEN pd.disastertraining = 1 AND pd.sex= 1 THEN 1 ELSE 0 END) AS `DM Trained Males`	
				, SUM(CASE WHEN pd.disastertraining = 1 AND pd.sex= 0 THEN 1 ELSE 0 END) AS `DM Trained Females`
	        FROM per_details pd
	        JOIN statemaster sm ON pd.state = sm.state
	        GROUP BY pd.state";
        }
        else if (distcd.IndexOf("state") > 0)
        {
            // SP login
            sql = string.Format(@"	
            SELECT mp.cat_name AS `District Name`
		        , COUNT(pd.sno) AS `Registered Total Members`
		        , SUM(IF(pd.sex = 1, 1, 0)) AS `Registered Males`
		        , SUM(IF(pd.sex = 0, 1, 0)) AS `Registered Females`
		        , SUM(CASE WHEN pd.mstatus = 'APPROVED' THEN 1 ELSE 0 END) AS `Total Approved`		
		        , SUM(CASE WHEN pd.sex= 1 AND pd.mstatus = 'APPROVED' THEN 1 ELSE 0 END) AS `Approved Males`
		        , SUM(CASE WHEN pd.sex= 0 AND pd.mstatus = 'APPROVED' THEN 1 ELSE 0 END) AS `Approved Females`		
		        , SUM(CASE WHEN pd.Guru_Balvikas = 1 AND pd.sex= 1 THEN 1 ELSE 0 END) AS `Balvikas Guru Males`	
				, SUM(CASE WHEN pd.Guru_Balvikas = 1 AND pd.sex= 0 THEN 1 ELSE 0 END) AS `Balvikas Guru Females`	
				, SUM(CASE WHEN pd.Stu_Balvikas = 1 AND pd.sex= 1 THEN 1 ELSE 0 END) AS `Balvikas Alumni Males`	
				, SUM(CASE WHEN pd.Stu_Balvikas = 1 AND pd.sex= 0 THEN 1 ELSE 0 END) AS `Balvikas Alumni Females`	
				, SUM(CASE WHEN pd.agerangeid > 5 AND pd.agerangeid < 8  AND pd.sex= 1 THEN 1 ELSE 0 END) AS `Sai Youth Males`	
				, SUM(CASE WHEN pd.agerangeid > 5 AND pd.agerangeid < 8  AND pd.sex= 0 THEN 1 ELSE 0 END) AS `Sai Youth Females`	
				, SUM(CASE WHEN pd.disastertraining = 1 AND pd.sex= 1 THEN 1 ELSE 0 END) AS `DM Trained Males`	
				, SUM(CASE WHEN pd.disastertraining = 1 AND pd.sex= 0 THEN 1 ELSE 0 END) AS `DM Trained Females`
	        FROM per_details pd
	        JOIN m_param mp ON mp.cat_typ = 'dist' AND mp.cat_cd = pd.dist_cd 
            WHERE {0}
	        GROUP BY pd.dist_cd", distcd);
        }
        else
        {
            // DP login
            sql = string.Format(@"	
           	SELECT pd.City AS `Samiti/BM Name`
		        , COUNT(pd.sno) AS `Registered Total Members`
		        , SUM(IF(pd.sex = 1, 1, 0)) AS `Registered Males`
		        , SUM(IF(pd.sex = 0, 1, 0)) AS `Registered Females`
		        , SUM(CASE WHEN pd.mstatus = 'APPROVED' THEN 1 ELSE 0 END) AS `Total Approved`		
		        , SUM(CASE WHEN pd.sex= 1 AND pd.mstatus = 'APPROVED' THEN 1 ELSE 0 END) AS `Approved Males`
		        , SUM(CASE WHEN pd.sex= 0 AND pd.mstatus = 'APPROVED' THEN 1 ELSE 0 END) AS `Approved Females`		
		        , SUM(CASE WHEN pd.Guru_Balvikas = 1 AND pd.sex= 1 THEN 1 ELSE 0 END) AS `Balvikas Guru Males`	
				, SUM(CASE WHEN pd.Guru_Balvikas = 1 AND pd.sex= 0 THEN 1 ELSE 0 END) AS `Balvikas Guru Females`	
				, SUM(CASE WHEN pd.Stu_Balvikas = 1 AND pd.sex= 1 THEN 1 ELSE 0 END) AS `Balvikas Alumni Males`	
				, SUM(CASE WHEN pd.Stu_Balvikas = 1 AND pd.sex= 0 THEN 1 ELSE 0 END) AS `Balvikas Alumni Females`	
				, SUM(CASE WHEN pd.agerangeid > 5 AND pd.agerangeid < 8  AND pd.sex= 1 THEN 1 ELSE 0 END) AS `Sai Youth Males`	
				, SUM(CASE WHEN pd.agerangeid > 5 AND pd.agerangeid < 8  AND pd.sex= 0 THEN 1 ELSE 0 END) AS `Sai Youth Females`	
				, SUM(CASE WHEN pd.disastertraining = 1 AND pd.sex= 1 THEN 1 ELSE 0 END) AS `DM Trained Males`	
				, SUM(CASE WHEN pd.disastertraining = 1 AND pd.sex= 0 THEN 1 ELSE 0 END) AS `DM Trained Females`
	        FROM per_details pd
	        WHERE pd.dist_cd = '{0}'
	        GROUP BY pd.City", distcd);
        }

        List<MySqlParameter> sqlParams = new List<MySqlParameter>();
        sqlParams.Add(new MySqlParameter("@DistCD", distcd));

        if (cmd.Contains("download"))
        {
            Executor executor = new Executor(conn, sql);
            DataTable dataTable = executor.Do(sqlParams);

            if (cmd == "download_csv")
            {
                Response.ContentType = "text/csv";
                Response.AddHeader("Content-Disposition", "attachment;filename=datasheet.csv");
                Response.Write(dataTable.ToCsv());
            }
            else if (cmd == "download_pdf")
            {
                ReportOptions options = new ReportOptions();
                options.title = "{0} Data Report";
                options.description = "This is report is generated for {0} on {1}";
                Response.AddHeader("Content-Type", "application/pdf");
                Response.AddHeader("Content-Disposition", "attachment;filename=datasheet.pdf");
                Response.BinaryWrite(dataTable.ToPdf(options));
            }
        }
        else
        {
            DataTableExecutor executor = new DataTableExecutor(Request, conn, sql, sqlParams);
            Response.Write(executor.ToDataTableResponse());
        }
    }

    private string Base64Decode(string encodedString)
    {
        byte[] data = Convert.FromBase64String(encodedString);
        return Encoding.UTF8.GetString(data);
    }
}