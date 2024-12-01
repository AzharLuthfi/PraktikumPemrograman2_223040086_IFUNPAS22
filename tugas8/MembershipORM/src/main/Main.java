package tugas8.MembershipORM.src.main;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import tugas8.MembershipORM.src.dao.JenisMemberDao;
import tugas8.MembershipORM.src.dao.MemberDao;
import tugas8.MembershipORM.src.view.main.MainFrame;

public class Main {
    public static void main(String[] args) throws IOException {

        String resource = "mybatis-config.xml";

        InputStream inputStream = Resources.getResourceAsStream(resource);

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        
        JenisMemberDao jenisMemberDao = new JenisMemberDao(sqlSessionFactory);
        MemberDao memberDao = new MemberDao(sqlSessionFactory);
        MainFrame f = new MainFrame(jenisMemberDao, memberDao);
        
        javax.swing.SwingUtilities.invokeLater(() -> {
            f.setVisible(true);
        });
    }
}