package com.multiVendor.validation;

public enum DataType implements EnumType {

    INT(1, "Int"),
    STRING(2, "String"),
    DATE(3, "Date"),
    FLOAT(5, "Float"),
    LONG(6, "Long"),
    TIME(7, "Time");

    private Integer id;
    private String name;

    DataType(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * This methods is used to fetch Enum base on given id.
     * 
     * @param id enum key
     * @return DataType enum
     */
    public static DataType getFromId(long id) {
        for (DataType fdt : DataType.values()) {
            if (fdt.id == id) {
                return fdt;
            }
        }
        return null;
    }
}