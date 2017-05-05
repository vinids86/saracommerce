package br.com.saracommerce.core;

/**
 * Created by vinicius on 03/05/17.
 */
public interface ORMAssembler<VO extends AbstractVO, ORM> {
    ORM toORM(VO vo);
}
