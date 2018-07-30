package cn.jxzhang.mybatis.model;

/**
 * Post
 *
 * @author zhangjiaxing
 * @version 1.0
 */
public class Post {

    private int postId;

    private String postName;

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    @Override
    public String toString() {
        return "Post{" +
                "postId=" + postId +
                ", postName='" + postName + '\'' +
                '}';
    }
}
