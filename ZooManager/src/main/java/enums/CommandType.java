package enums;

public enum CommandType {
    CREATE_ANIMAL("Создать животное"), PRINT_ALL_ANIMALS("Вывести животных на экран"),
    DELETE_ANIMAL("Удалить животное"), RENAME_ANIMAL("Переименовать животное");
    private final String value;

    CommandType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }


}
