package cn.web1992.utils.demo.factory;

/**
 * Created by web1992 on 2016/8/29.
 *
 * @desc
 */
public class TeacherFactory extends PeopleAbstractFactory {

    @Override
    public People create() {
        return new Teacher();
    }
}
