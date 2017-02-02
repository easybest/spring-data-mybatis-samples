/*
 * Kopax Ltd Copyright (c) 2017.
 */

package org.springframework.data.mybatis.samples.security;

import org.springframework.data.mybatis.repository.support.MybatisRepository;
import org.springframework.data.mybatis.samples.security.projection.SiteContentDefaultProjection;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "siteContents", excerptProjection = SiteContentDefaultProjection.class)
public interface SiteContentRepository extends MybatisRepository<SiteContent, Long> {

}