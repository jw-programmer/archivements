package br.com.gamearchivement.gamearchivements.Enuns;

public enum Roles {
    ADMIN(1, "ROLE_ADMIM"),
    PLAYER(2, "ROLE_PLAYER");

    private int cod;
	private String role;

    private Roles(int cod, String role) {
        this.cod = cod;
        this.role = role;
    }

    public int getCod() {
        return cod;
    }

    public String getRole() {
        return role;
    }

    public static Roles toEnum(Integer code){
        if(code == null){
            return null;
        }
        for(Roles x: Roles.values()){
            if(code.equals(x.getCod())){
                return x;
            }
        }

        throw new IllegalArgumentException("Code Invalid: " + code);
    }
}
