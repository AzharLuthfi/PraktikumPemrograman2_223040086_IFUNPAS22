
import model.MyBatisUtil;
import model.UserMapper;
import org.apache.ibatis.session.SqlSession;
import controller.UserController;
import view.UserPdf;
import view.UserView;


public class Main {
    public static void main(String[] args) {
        SqlSession session = MyBatisUtil.getSqlSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        UserView view = new UserView();
        UserPdf pdf = new UserPdf();
        
        new UserController(view, mapper, pdf);

        view.setVisible(true);
    }
}

