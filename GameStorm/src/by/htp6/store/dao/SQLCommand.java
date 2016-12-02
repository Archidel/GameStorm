package by.htp6.store.dao;

public class SQLCommand {
	public static final String INSERT_SINGUP_USER = "INSERT INTO users (name, surname, yearsOld, email, login, password) VALUES (?,?,?,?,?,?)";
	public static final String INSERT_INTO_GAME = "INSERT INTO games (name, price, developer, dateRelease, partOfSeries, genre, image, site, description, gameplay) VALUE (?,?,?,?,?,?,?,?,?,?)";
	
	public static final String SELECT_FROM_USERS = "SELECT * FROM users";
	public static final String SELECT_FROM_GAMES = "SELECT * FROM games";
	public static final String SELECT_FROM_ORDERS = "SELECT * FROM oreders";
	public static final String SELECT_FROM_GAMES_IN_ORDER = "SELECT * FROM games_in_order";
	
	public static final String UPDATE_USER_EDIT_PROFILE = "UPDATE users SET name = ?, surname = ?, yearsOld = ?, email = ?, password = ? WHERE id = ?";
	public static final String UPDATE_USER_SET_ACCESS_LEVEL = "UPDATE users SET accessLevel = ? WHERE id = ?";
	public static final String UPDATE_USER_SET_STATUS = "UPDATE users SET status = ? WHERE id = ?";
	public static final String UPDATE_GAME_SET_STATUS = "UPDATE games SET status = ? WHERE id = ?";
	public static final String UPDATE_GAME_EDIT = "UPDATE games SET name = ?, price = ?, developer = ?, dateRelease = ?, partOfSeries = ?, genre = ?, image = ?, site = ?, description = ?, gameplay = ? WHERE id = ?";
}
