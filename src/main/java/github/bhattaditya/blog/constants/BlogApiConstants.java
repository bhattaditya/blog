package github.bhattaditya.blog.constants;

public class BlogApiConstants {

    // POST
    public static final String CREATE_POST = "/addPost/user/{userId}/category/{categoryId}";

    public static final String POSTS = "/getAll";

    public static final String POST = "/get/{postId}";

    public static final String POST_CATEGORY = "/get/category/{categoryId}";

    public static final String POST_USER = "/get/user/{userId}";

    public static final String UPDATE_POST = "/update/{postId}";

    public static final String REMOVE_POST = "/remove/{postId}";

    // USER
    public static final String CREATE_USER = "/addUser";

    public static final String USERS = "/getAll";

    public static final String USER = "/get/{userId}";

    public static final String UPDATE_USER = "/update/{userId}";

    public static final String REMOVE_USER = "/remove/{userId}";

    // CATEGORY
    public static final String CREATE_CATEGORY = "/addCategory";

    public static final String CATEGORIES = "/getAll";

    public static final String CATEGORY = "/get/{categoryId}";

    public static final String UPDATE_CATEGORY = "/update/{categoryId}";

    public static final String REMOVE_CATEGORY = "/remove/{categoryId}";
}
