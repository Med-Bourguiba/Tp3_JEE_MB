package metier;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;


public class MetierImpl implements ImetierCatalogue {
@Override
	public List<Produit> getProduitsParMotCle(String mc) {
	List<Produit> prods= new ArrayList<Produit>();
	Connection conn=SingletonConnection.getConnection();
 try {
		PreparedStatement ps= (PreparedStatement) conn.prepareStatement("select * from PRODUITS where NOM_PRODUIT LIKE ?");
		ps.setString(1, "%"+mc+"%");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
		Produit p = new Produit();
		p.setIdProduit(rs.getLong("ID_PRODUIT"));
		p.setNomProduit(rs.getString("NOM_PRODUIT"));
		p.setPrix(rs.getDouble("PRIX"));
		prods.add(p);
	}
} catch (SQLException e) {
e.printStackTrace();
}
return prods;
}
@Override
public void addProduit(Produit p) {
// TODO Auto-generated method stub
}
}
