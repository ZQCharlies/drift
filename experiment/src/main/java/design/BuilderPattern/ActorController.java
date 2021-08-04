package design.BuilderPattern;

/**
 * @Author wzq
 * @Date 2021/8/4
 * 游戏角色创建控制器：指挥者
 **/
public class ActorController {

    public static Actor construct(ActorBuilder ab){
        Actor actor;
        ab.buildCostume();
        ab.buildFace();
        ab.buildHairstyle();
        ab.buildSex();
        ab.buildType();
        actor = ab.createActor();
        return actor;
    }
    
    //具体使用
    public static void main(String[] args) {
        //创建英雄
        Actor construct = ActorController.construct(new AngelActorBuilder());
    }
}
