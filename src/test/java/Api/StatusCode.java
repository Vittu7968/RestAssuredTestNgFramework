package Api;

public enum StatusCode {
	CODE_200(200, ""),
	CODE_201(201, ""),
	CODE_400(400, "Missing required field: name"),
	CODE_401(401, "Invalid access token"),;

	//If we are using private variables we need the getter and setter methos , if not its not required
//	private final int code;
//	private final String message;
	public final int code;
	public final String message;
	
	
	StatusCode(int code, String message) {
		this.code=code;
		this.message=message;
	}
	
//	public int getCode() {
//		return code;
//	}
//
//	public String getMessage() {
//		return message;
//	}
}
