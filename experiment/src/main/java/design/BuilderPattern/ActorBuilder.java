package design.BuilderPattern;

/**
 * @Author wzq
 * @Date 2021/8/4
 * 角色建造器：抽象建造器
 **/
abstract class ActorBuilder {

    protected Actor actor = new Actor();

    public abstract void buildType();
    public abstract void buildSex();
    public abstract void buildFace();
    public abstract void buildCostume();
    public abstract void buildHairstyle();

    //返回一个具体对象
    public Actor createActor(){
        return actor;
    }
}
