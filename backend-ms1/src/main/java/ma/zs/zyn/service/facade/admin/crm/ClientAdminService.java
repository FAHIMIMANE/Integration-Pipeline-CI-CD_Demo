package ma.zs.zyn.service.facade.admin.crm;

import java.util.List;
import ma.zs.zyn.bean.core.crm.Client;
import ma.zs.zyn.dao.criteria.core.crm.ClientCriteria;
import ma.zs.zyn.zynerator.service.IService;



public interface ClientAdminService {


    Client findByUsername(String username);
    boolean changePassword(String username, String newPassword);





	Client create(Client t);

    Client update(Client t);

    List<Client> update(List<Client> ts,boolean createIfNotExist);

    Client findById(Long id);

    Client findOrSave(Client t);

    Client findByReferenceEntity(Client t);

    Client findWithAssociatedLists(Long id);

    List<Client> findAllOptimized();

    List<Client> findAll();

    List<Client> findByCriteria(ClientCriteria criteria);

    List<Client> findPaginatedByCriteria(ClientCriteria criteria, int page, int pageSize, String order, String sortField);

    int getDataSize(ClientCriteria criteria);

    List<Client> delete(List<Client> ts);

    boolean deleteById(Long id);

    List<List<Client>> getToBeSavedAndToBeDeleted(List<Client> oldList, List<Client> newList);

    public String uploadFile(String checksumOld, String tempUpladedFile,String destinationFilePath) throws Exception ;

}
