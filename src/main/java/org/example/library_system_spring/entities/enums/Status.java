package org.example.library_system_spring.entities.enums;

public enum Status {
    ACTIVE(1),
    RETURNED(2);


    private int code;

    private Status(int code){
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static Status valueOf(int code){
        for(Status value : Status.values()){
            if(value.getCode() == code){
                return value;
            }
        }
        throw  new IllegalArgumentException("INVALID Status code");
    }
}
