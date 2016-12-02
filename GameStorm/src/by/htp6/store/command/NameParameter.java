package by.htp6.store.command;

public class NameParameter {
	//CommandProvider
	public static final String CMD_DESTROY_DAO = "destroy_dao";
	public static final String CMD_INIT_DAO = "init_dao";
	public static final String CMD_LOCALIZATION = "localization";
	public static final String CMD_SING_IN_USER = "sing_in_user";
	public static final String CMD_SING_UP_USER = "sing_up_user";
	public static final String CMD_RANDOM_GAME = "random_game";
	public static final String CMD_SEARCH = "search";
	public static final String CMD_EDIT_PROFILE = "edit_profile";
	public static final String CMD_EXIT_FROM_ACCOUNT = "exit_from_account";
	public static final String CMD_ADD_NEW_GAME = "add_new_game";
	public static final String CMD_EDIT_GAME = "edit_game";
	public static final String CMD_SHOW_GAME_LIST = "show_game_lsit";
	public static final String CMD_SHOW_USER_LIST = "show_user_list";
	public static final String CMD_STATUS_AND_LEVEl = "status_and_level";
	public static final String CMD_ADD_TO_BLACK_LIST = "add_to_black_list";
	public static final String CMD_UP_DOWN_ACCESS_LEVEL = "up_down_access_level";
	public static final String CMD_REMOVE_GAME = "remove_game";
	public static final String CMD_MORE_ABOUT_GAME = "more_about_game";
	public static final String CMD_ADD_TO_CART = "add_to_cart";
	public static final String CMD_REMOVE_FROM_CART = "remove_from_cart";
	public static final String CMD_MAKE_ORDER = "make_order";
	//Parameters
		//General
	public static final String PRM_COMMAND = "command";
		//Search
	public static final String PRM_SEARCH_NAME = "search_name";
	public static final String PRM_SEARCH_GENRE = "search_genre";
	public static final String PRM_SEARCH_GAMEPLAY = "search_gameplay";
		//User
	public static final String PRM_USER_NAME = "user_name";
	public static final String PRM_USER_SURNAME = "user_surname";
	public static final String PRM_USER_EMAIL = "user_email";
	public static final String PRM_USER_LOGIN = "user_login";
	public static final String PRM_USER_YEARS_OLD = "user_years_old";
	public static final String PRM_USER_PASSWORD = "user_password";
	public static final String PRM_USER_RE_PASSWORD = "user_re_password";
	public static final String PRM_USER_OLD_PASSWORD = "user_old_password";
		//Game
	public static final String PRM_GAME_NAME = "game_name";
	public static final String PRM_GAME_PRICE = "game_price";
	public static final String PRM_GAME_DEVELOPER = "game_developer";
	public static final String PRM_GAME_DATA_RELEASE = "game_data_release";
	public static final String PRM_GAME_PART_OF_SERIES = "game_part_of_series";
	public static final String PRM_GAME_GENRE = "game_genre";
	public static final String PRM_GAME_IMAGE = "game_image";
	public static final String PRM_GAME_SITE = "game_site";
	public static final String PRN_GAME_STATUS = "game_status";
	public static final String PRM_GAME_DESCRIPTION = "game_description";
	public static final String PRM_GAME_ID = "game_id";
	public static final String PRM_GAME_GAMEPLAY = "gameplay";

	public static final String PRM_GAME_EDIT_SUCCESS = "edit_game_success";
	public static final String PRM_OBJECT_GAME = "obj_game";
		//cart
	public static final String PRM_REMOVE_FROM_CART_ALL = "all";
	public static final String PRM_REMOVE_FROM_CART_ONE = "one";
	public static final String PRM_REMOVE_GAME_FORM_CART = "remove";
	public static final String PRM_REQUEST_FROM_PAGE = "request_from_page";
	
	
}
