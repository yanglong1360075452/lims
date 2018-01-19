package com.wizinno.lims.common.query;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author LiuMei
 *         定义一个查询条件容器
 */
public class Criteria<T> implements Specification<T> {
    private List<Criterion> criterions = new ArrayList<>();
    private HashMap<String, String> orders = new HashMap();

    @Override
    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query,
                                 CriteriaBuilder builder) {
        if (MapUtils.isNotEmpty(orders)) {
            for (Map.Entry<String, String> entry : orders.entrySet()) {
                String name = entry.getKey();
                String order = entry.getValue();
                if (order.equalsIgnoreCase("asc")) {
                    query.orderBy(builder.asc(root.get(name)));
                }else {
                    query.orderBy(builder.desc(root.get(name)));
                }
            }
        }
        if (CollectionUtils.isNotEmpty(criterions)) {
            List<Predicate> predicates = new ArrayList<>();
            for (Criterion c : criterions) {
                predicates.add(c.toPredicate(root, query, builder));
            }
            // 将所有条件用 and 联合起来
            if (predicates.size() > 0) {
                return builder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        }
        return builder.conjunction();
    }

    /**
     * 增加简单条件表达式
     */
    public void add(Criterion criterion) {
        if (criterion != null) {
            criterions.add(criterion);
        }
    }

    public void addOrder(String propertyName, String order) {
        if (StringUtils.isNotBlank(propertyName) && StringUtils.isNotBlank(order)) {
            orders.put(propertyName, order);
        }
    }
}
