package tc.pbkk.servistukangantar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tc.pbkk.servistukangantar.dao.DeliveryRepository;
import tc.pbkk.servistukangantar.model.Delivery;

@Service
public class DeliveryServiceImpl implements DeliveryService{
	
	@Autowired
	private DeliveryRepository deliveryRepository;

	@Override
	public Delivery addDelivery(Delivery delivery) {
		deliveryRepository.save(delivery);
		
		return delivery;
	}

	@Override
	public Delivery getDelivery(Integer deliveryId) {
		
		return deliveryRepository.findById(deliveryId).get();
	}

	@Override
	public Delivery updateDelivery(Integer id,Delivery delivery) {
		if (getDelivery(id) == null) {
			throw new RuntimeException("Not Available");
		}
		delivery.setId(id);
		deliveryRepository.save(delivery);
		
		return delivery;
	}

}