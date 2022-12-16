package com.amaro.microsservices.repositories;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.amaro.microsservices.entity.Shop;

import br.com.microsservices.dtos.ShopReportDTO;

public class ReportRepositoryImpl implements ReportRepository {
	//Objeto para fazar conexão com o banco de dados
		@PersistenceContext
		private EntityManager entityManager;
		
		@Override
		public List<Shop> getShopByFilters(Date dataInicio, Date dataFim, Float valorMinimo){
			StringBuilder sb = builderShopByFilter(dataInicio, dataFim, valorMinimo);	
			Query query = queryShopByFilter(dataInicio,  dataFim,  valorMinimo,  sb);
			
			return resultShopByFilter(query);
			
		}
		
		@Override
		public ShopReportDTO getReportByDate(Date dataInicio, Date dataFim) {
			StringBuilder sb = builderReportByDate(dataInicio, dataFim);
			Query query = queryReportByDate(dataInicio, dataFim, sb);
			
			return resultReportShop(query);
		}
		
		private StringBuilder builderShopByFilter(Date dataInicio, Date dataFim, Float valorMinimo) {
			StringBuilder sb = new StringBuilder();
			sb.append("select s from shop s ");
			sb.append("where s.date >= :dataInicio ");
			
			if(dataFim != null) {
				sb.append("and s.date <= :dataFim ");
			}
			
			if(valorMinimo != null) {
				sb.append("and s.total <= :valorMinimo ");
			}
	
			return sb;
		}
		
		private Query queryShopByFilter(Date dataInicio, Date dataFim, Float valorMinimo, StringBuilder sb) {
			
			Query query = entityManager.createQuery(sb.toString());
			query.setParameter("dataInicio", dataInicio);
			
			if(dataFim != null) {
				query.setParameter("dataFim", dataFim);
			}
			
			if(valorMinimo != null) {
				query.setParameter("valorMinimo", valorMinimo);
			}
			return query;
		}
		
		private List<Shop> resultShopByFilter(Query query) {
			List<Shop> shops = query.getResultList(); 
			return shops;
		}
		
		private StringBuilder builderReportByDate(Date dataInicio, Date dataFim) {
			StringBuilder sb = new StringBuilder();
			sb.append("select count(sp.id),  sum(sp.total),  avg(sp.total) ");
			sb.append("from shopping.shop sp ");
			sb.append("where sp.date >= :dataInicio ");
			sb.append("and sp.date <= :dataFim ");
			
			return sb;
		}

		
		private Query  queryReportByDate(Date dataInicio, Date dataFim, StringBuilder sb) {
			Query query = entityManager.createNativeQuery(sb.toString());
			query.setParameter("dataInicio", dataInicio);
			query.setParameter("dataFim", dataFim); 
			
			return query;
		}
		
		private ShopReportDTO resultReportShop(Query query) {
			
			Object[] result = (Object[]) query.getSingleResult();
			ShopReportDTO shopReportDTO = new ShopReportDTO();			
			shopReportDTO.setCount(((BigInteger) result[0]).intValue());
			shopReportDTO.setTotal((Double) result[1]);
			shopReportDTO.setMean((Double) result[2]);
			
			return shopReportDTO;
		}
}