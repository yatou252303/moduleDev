package com.component.model.evenbus;

import com.component.model.db.ListItemBO;

/**
 * Created by weichyang on 2018/4/28.
 */

public class DeleteItem {
   public ListItemBO listItemBO;

    public DeleteItem(ListItemBO listItemBO) {
        this.listItemBO = listItemBO;

    }
}
