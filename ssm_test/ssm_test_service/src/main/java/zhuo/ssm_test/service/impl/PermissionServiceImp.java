package zhuo.ssm_test.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zhuo.ssm_test.dao.IPermissionDao;
import zhuo.ssm_test.domain.Permission;
import zhuo.ssm_test.service.IPermissionService;

import java.util.List;

@Service
@Transactional
public class PermissionServiceImp implements IPermissionService{

    @Autowired
    private IPermissionDao iPermissionDao;

    @Override
    public List<Permission> findAll() throws Exception {
        List<Permission> all = iPermissionDao.findAll();

        return all;
    }

    @Override
    public void save(Permission permission) throws Exception {
        iPermissionDao.save(permission);
    }

    @Override
    public Permission findById(String id) throws Exception {
        Permission permission = iPermissionDao.findById(id);

        return permission;
    }
}
