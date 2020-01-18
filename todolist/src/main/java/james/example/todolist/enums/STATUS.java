package james.example.todolist.enums;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;

public enum STATUS {

    PLANNING(1, "Planning"),
    DOING(2, "Doing"),
    COMPLETE(9, "Complete");

    @Getter
    private int code;

    @Getter
    private String value;

    private static Map<Integer, STATUS> valueMap = new HashMap<Integer, STATUS>();
    static {
        for (STATUS errorType : STATUS.values()) {
            valueMap.put(errorType.code, errorType);
        }
    }

    private STATUS(int code, String value) {
        this.code = code;
        this.value = value;
    }

    /**
     * Get STATUS from code
     * 
     * @param code
     * @return STATUS
     */
    public static STATUS convertFromCodeToEnum(int code) {
        return valueMap.get(code);
    }
}
