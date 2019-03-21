package lc.service;

import com.lc.entity.SysUser;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author liuchaoOvO on 2019/3/19
 */
@Component
public class ConsumerServiceFallbackFactory implements FallbackFactory<ConsumerService>
{

    @Override
    public ConsumerService create(Throwable arg0) {
        // TODO Auto-generated method stub
        return new ConsumerService() {

            @Override
            public List<SysUser> getAll() {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            //服务被关掉了，请求失败时执行
            public SysUser get(int id) {
                SysUser user = new SysUser(id, "==ConsumerServiceFallbackFactory==该用户不存在", "ConsumerServiceFallbackFactory password");
                return user;
            }

            @Override
            public boolean add(SysUser user) {
                // TODO Auto-generated method stub
                return false;
            }
        };
    }

}
