package space.levan.wallpapers.repo.api.exception;

/**
 * @author WangZhiYao
 * @date 2019/12/6
 */
public class ApiException extends Exception {

    private int code;
    private String msg;

    public ApiException(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public static class NoResponse extends ApiException {

        public NoResponse() {
            super(ErrorCode.NO_RESPONSE, "no response");
        }
    }

    public static class UnknowError extends ApiException {

        public UnknowError() {
            super(ErrorCode.UNKNOWN_ERROR, "unknown error");
        }
    }

    public static class ParseError extends ApiException {

        public ParseError() {
            super(ErrorCode.PARSE_ERROR, "parse failed");
        }
    }
}
