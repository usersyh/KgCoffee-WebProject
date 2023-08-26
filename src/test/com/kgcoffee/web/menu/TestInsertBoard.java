package test.com.kgcoffee.web.menu;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.kgcoffee.web.board.dao.SnsDAO;
import com.kgcoffee.web.voc.dao.VocDAO;

class TestInsertBoard {

	@Test
	void testExecute() {

		try {
//			SnsDAO dao = new SnsDAO();
			VocDAO dao = new VocDAO();
			
			String jemok = "";
			String writer = "";
			String content = "";
			String filename = "";

			for (int i = 1; i <= 100; i++) {
				
				
				jemok = "문의사항"+i;
				content = "내용입니다"+i;
				filename="";
				writer = "유저"+i;
				assertEquals(true, dao.insert(jemok, writer, content, filename, "user"+i));


			}

		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
