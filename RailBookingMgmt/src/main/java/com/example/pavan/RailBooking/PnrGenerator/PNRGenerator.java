package com.example.pavan.RailBooking.PnrGenerator;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class PNRGenerator implements IdentifierGenerator {

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		String prefix = "PASS1800";
		Connection con = session.connection();
		
		try {
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery("select count(PNR) as pnr from PASSENGER");
		    if(rs.next())
            {
                int id=rs.getInt(1)+101;
                String generatedId = prefix + new Integer(id).toString();
                return generatedId;
            }
		}
		    catch (SQLException e) {
		    	e.printStackTrace();		
		    	}		return null;
	}

}
