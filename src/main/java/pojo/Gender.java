package pojo;

public enum Gender {
    MAN("男"),WOMEN("女"),NONE("无");
    private String sex;
    private Gender(String sex){
        this.sex=sex;
    }
    public String getSex(){
        return sex;
    }
}
