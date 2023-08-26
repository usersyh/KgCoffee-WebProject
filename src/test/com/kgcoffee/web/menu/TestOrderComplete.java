package test.com.kgcoffee.web.menu;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

import org.junit.jupiter.api.Test;

import com.kgcoffee.web.order.controller.cart.CartInsertController;
import com.kgcoffee.web.order.controller.order.OrderCompleteController;

class TestOrderComplete {

	@Test
	void test() {

		OrderCompleteController order = new OrderCompleteController();

		Map<String, String> paramMap = new HashMap<String, String>();

		Map<String, Object> model = new ConcurrentHashMap<>();

		int[] mapList = { 13523073, 636115618, 1513915761, 749077826, 580775378, 1219966946, 1783055633, 1818780464,
				2145132677, 106236168, 1909296784, 1685691174, 747918712, 647301621, 1323632404, 1152502740, 1498484900,
				1341309076, 1468934377, 784834988, 162621148, 2106508030, 1032483576, 1245107524, 780157427, 1155767189,
				1553974246, 1034793680, 493912591, 401373292, 653240686, 1889025818, 549506889, 90655469, 722183296,
				945711059, 1199724556, 213340971, 507418565, 1548342229, 552038264, 65006656, 288964249, 630938170,
				1431075566, 74480595, 1214666691, 2112438851, 455132298, 406120351, 1599451385, 1284530980, 620964534,
				1724389758, 1049624872, 2016409494, 1081581516, 1416376094, 779908361, 1938450446, 309901823 };

		for (int k = 0; k < 10; k++) {

			for (int i = 1; i <= 200; i++) {

				CartInsertController insert = new CartInsertController();

				Map<String, String> paramMap2 = new HashMap<String, String>();

				Map<String, Object> model2 = new ConcurrentHashMap<>();

				for (int j = 0; j < 5; j++) {
					paramMap2.put("userId", "user" + i);
					paramMap2.put("menuId", "" + (int) (Math.ceil(Math.random() * 22)));
					paramMap2.put("menuAmount", "" + (int) (Math.ceil(Math.random() * 30)));

					insert.process(paramMap2, model2);
				}

				Random random = new Random();

				String paidAt = random.nextInt(1688109043) + "";

				paramMap.put("userId", "user" + i);
				paramMap.put("paid_at", "" + paidAt);
				paramMap.put("paid_amount", "" + (i * 1000));
				paramMap.put("total_price", "" + (i * 1000));
				paramMap.put("map_id", "" + mapList[(int) (Math.ceil(Math.random() * 60))]);
				paramMap.put("imp_uid", "" + i);

				order.process(paramMap, model);
			}

		}
	}

}
