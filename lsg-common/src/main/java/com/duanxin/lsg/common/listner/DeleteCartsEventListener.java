package com.duanxin.lsg.common.listner;

import com.duanxin.lsg.common.module.DeleteCartsEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author duanxin
 * @version 1.0
 * @className DeleteCartsEventListener
 * @date 2020/11/01 14:02
 */
@Component
public class DeleteCartsEventListener {

    @EventListener
    public void action(DeleteCartsEvent event) {
        // todo: del cart to db
    }
}
