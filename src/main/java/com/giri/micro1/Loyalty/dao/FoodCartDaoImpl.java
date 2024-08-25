package com.giri.micro1.Loyalty.dao;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.giri.micro1.Loyalty.model.AdminProduct;
import com.giri.micro1.Loyalty.model.FoodItemCart;

import jakarta.persistence.EntityManager;

//@Repository
//public class FoodCartDaoImpl implements FoodCartDao {
//	
//	@Autowired
//	private EntityManager entity;
//
//	@Override
//	public boolean validateCart(FoodItemCart cart) {
//		try {
//			AdminProduct adminProduct = cart.getAdminProduct();
//			long prodId = adminProduct.getProductId();
//			Query<FoodItemCart> query = (Query<FoodItemCart>) entity.createQuery("FROM FoodItemCart as cart where cart.adminProduct.productId=:id");
//			query.setParameter("id", prodId);
//			FoodItemCart cart1 = query.getSingleResult();
//			return true;
//			
//			}catch (Exception e) {
//				return false;
//			}
//
//}
//	
//
//	@Override
//	public FoodItemCart findCartById(Long cartId) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public String updateCart(FoodItemCart cart) {
//		
//		return null;
//	}
//
//	@Override
//	public String deleteOrder(Long cartId) {
//		String msg = "";
//		FoodItemCart cart = entity.find(FoodItemCart.class, cartId);
//		try {
//			entity.remove(cart);
//			return msg = "deletion success";
//		} catch (Exception e) {
//			return msg = "deletion failure";
//		}
//	}
//
//	@Override
//	public List<FoodItemCart> listAllCart() {
//		List<FoodItemCart> cartList = entity.createQuery("from FoodItemCart").getResultList();
//		return cartList;
//
//	}
//
//	@Override
//	public void insertCart(FoodItemCart cart) {
//		System.err.println(cart);
//		try {
//			entity.persist(cart);
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//
//}

@Repository
public class FoodCartDaoImpl implements FoodCartDao {
    
    @Autowired
    private EntityManager entity;

    @Override
    public boolean validateCart(FoodItemCart cart) {
        try {
            AdminProduct adminProduct = cart.getAdminProduct();
            long prodId = adminProduct.getProductId();
            Query<FoodItemCart> query = (Query<FoodItemCart>) entity.createQuery("FROM FoodItemCart as cart where cart.adminProduct.productId=:id");
            query.setParameter("id", prodId);
            query.getSingleResult();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public FoodItemCart findCartById(Long cartId) {
        return entity.find(FoodItemCart.class, cartId);
    }

    @Override
    public String updateCart(FoodItemCart cart) {
        try {
            FoodItemCart existingCart = entity.find(FoodItemCart.class, cart.getCartId());
            if (existingCart != null) {
                existingCart.setTotalPrice(cart.getTotalPrice());
                existingCart.setCartprice(cart.getCartprice());
                existingCart.setPoints(cart.getPoints());
                existingCart.setQuantity(cart.getQuantity());
                entity.merge(existingCart);
                return "Update Success";
            }
            return "Cart not found";
        } catch (Exception e) {
            return "Update Failure";
        }
    }

    @Override
    public String deleteOrder(Long cartId) {
        try {
            FoodItemCart cart = entity.find(FoodItemCart.class, cartId);
            if (cart != null) {
                entity.remove(cart);
                return "Deletion Success";
            }
            return "Cart not found";
        } catch (Exception e) {
            return "Deletion Failure";
        }
    }

    @Override
    public List<FoodItemCart> listAllCart() {
        return entity.createQuery("FROM FoodItemCart", FoodItemCart.class).getResultList();
    }

    @Override
    public void insertCart(FoodItemCart cart) {
        try {
            entity.persist(cart);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}