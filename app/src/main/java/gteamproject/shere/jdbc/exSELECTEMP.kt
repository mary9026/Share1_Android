package gteamproject.shere.jdbc

import android.os.AsyncTask
import android.util.Log
import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet

class exSELECTEMP : AsyncTask<Void?, Void?, Void?>() {

    companion object{
        const val selectSQL ="select employee_id, first_name, last_name from EMPLOYEES"
        const val selectOneSQL ="select * from EMPLOYEES where employee_id = ?"
    }


    override fun doInBackground(vararg params: Void?): Void? {
        var conn: Connection? = null
        var pstmt: PreparedStatement? = null
        var rs: ResultSet? = null

        try{
            conn = JDBCUtil.makeConn()
            pstmt = conn!!.prepareStatement(selectSQL)
            rs = pstmt.executeQuery()

            var sb = StringBuilder()
            while(rs.next()){
                sb.append(rs.getString("employee_id")).append("/")
                sb.append(rs.getString("first_name")).append("/")
                sb.append(rs.getString("last_name")).append("\n")
            }
            Log.d("jdbc", sb.toString())
        } catch (ex: Exception){
            ex.printStackTrace()
        }finally {
            JDBCUtil.destoryConn(conn, pstmt, rs)
        }

        return null
    }
}