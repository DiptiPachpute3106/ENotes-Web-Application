package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.User.Post;

public class PostDAO {
    private Connection con;

    public PostDAO(Connection con) {
        this.con = con;
    }

    public boolean addPost(String title, String content, int userId) {
        boolean isSuccess = false;
        try {
            String query = "INSERT INTO post(title, content, uid) VALUES(?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, title);
            ps.setString(2, content);
            ps.setInt(3, userId);
            int result = ps.executeUpdate();
            if (result == 1) {
                isSuccess = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isSuccess;
    }

    public List<Post> getPostsByUserId(int userId) {
        List<Post> posts = new ArrayList<>();
        try {
            String query = "SELECT * FROM post WHERE uid = ? ORDER BY id DESC";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Post post = new Post();
                post.setId(rs.getInt("id"));
                post.setTitle(rs.getString("title"));
                post.setContent(rs.getString("content"));
                post.setDate(rs.getTimestamp("date"));
                posts.add(post);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return posts;
    }
    
    public Post getDataById(int noteId)
    {
    	Post p=null;
    	try
    	{
    		String qu="select * from post where id=?";
    		PreparedStatement ps=con.prepareStatement(qu);
    		ps.setInt(1, noteId);
    		ResultSet rs=ps.executeQuery();
    		
    		if(rs.next())
    		{
    			p=new Post();
    			 p.setId(rs.getInt("id"));
                 p.setTitle(rs.getString("title"));
                 p.setContent(rs.getString("content"));
    			
    		}
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	
    	return p;
    }
    
    
    public boolean PostUpdate(int nid,String ti,String co)
    {
    	boolean f=false;
    	try {
    		String qu="update post set title=?, content=? where id=?";
    		PreparedStatement ps=con.prepareStatement(qu);
    		ps.setString(1, ti);
    		ps.setString(2, co);
    		ps.setInt(3, nid);
    		
    		int i=ps.executeUpdate();
    		if(i==1)
    		{
    			f=true;
    			
    		}
    		
    	}catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	return f;
    }
    public boolean DeleteNotes(int nid)
    {
    	boolean f=false;
    	try {
    		String qu="delete from post where id=?";
    		PreparedStatement ps=con.prepareStatement(qu);
    		ps.setInt(1, nid);
    	
    		
    		int x=ps.executeUpdate();
    		if(x==1)
    		{
    			f=true;
    			
    		}
    		
    	}catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	return f;
    }
}
