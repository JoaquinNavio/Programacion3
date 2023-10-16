package com.example.primeraAPIREST.config;

import com.example.primeraAPIREST.entities.audit.Revision;
import org.hibernate.envers.RevisionListener;

public class CustomRevisionListener implements RevisionListener {
    public void newRevision(Object revisionEntity){final Revision revision = (Revision) revisionEntity;}
}
