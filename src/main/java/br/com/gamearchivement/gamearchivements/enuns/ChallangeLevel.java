package br.com.gamearchivement.gamearchivements.enuns;

public enum ChallangeLevel {
    PLATINUM(4, "platinun"), EASY(1, "easy"), MEDIUM(2, "medium"), HARD(3, "hard");

    private int level;
    private String desc;

    private ChallangeLevel(int level, String desc) {
        this.level = level;
        this.desc = desc;
    }

    public int getLevel() {
        return level;
    }

    public String getDesc() {
        return desc;
    }

    public static ChallangeLevel toEnum(Integer level){
        if(level == null){
            return null;
        }
        for(ChallangeLevel x: ChallangeLevel.values()){
            if (level.equals(x.getLevel())){
                return x;
            }
        }

        throw new IllegalArgumentException("Level invalid: " + level);
    }
}
