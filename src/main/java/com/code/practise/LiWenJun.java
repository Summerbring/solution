package com.code.practise;

import lombok.Data;

/**
 * description
 *
 * @author Summer 2021/02/05 16:43
 */
@Data
public class LiWenJun extends DiaoMao {

    private String family;

    private final static String name = "李文俊";

    public void selfIntroduction() {
        super.selfIntroduction(name);
    }
}
