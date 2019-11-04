package zhuo.ssm_test.service;

import zhuo.ssm_test.domain.Permission;

import java.util.List;

public interface IPermissionService {

    public List<Permission> findAll() throws Exception;

    public void save(Permission permission) throws Exception;

    public Permission findById(String id) throws Exception;
}
