package com.axity.arquitectura.bestpractices.artista.impl;

import com.axity.arquitectura.bestpractices.artista.ArtistaService;
import com.axity.arquitectura.bestpractices.artista.model.*;
import com.axity.arquitectura.bestpractices.artista.to.CatalogoTO;
import com.axity.arquitectura.bestpractices.artista.to.FileCreditFilterTO;
import com.axity.arquitectura.bestpractices.artista.to.ViewFileCreditTO;
import com.axity.arquitectura.bestpractices.base.DataMockBase;
import com.axity.arquitectura.bestpractices.data.ArtistaTO;

import javax.persistence.EntityManager;
import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ArtistaServiceImpl extends DataMockBase implements ArtistaService{


    private EntityManager em;


    public List<ArtistaTO> buscarPorNombre(String nombre) {
        System.out.println(" SIZE ::: " + artistas.size());
        return artistas;
    }

    public void validaNull(){

    }

    /**
     * 1.- Buscar a los artistas que tengan un rango de edad entre 20-25{} y mostrar una LEYENDA de "Jovenes Promesas"
     * 2.- Contar cuantos Artistas tienen la misma edad de 25 al 45 y de 50 al 60
     * 3.- Sobre escribir el nombre de los siguientes rangos  (1- 20 --- Neymar) (25 a 50 Don Julio)  (50 a 75 Don Ramon), (75 a 100 Dejar el default).
     *
     * */
    public void buscarEdadNombre(){

    }



    private void referenceJPA(FileCreditFilterTO fileCreditFilterTO){
        List<ViewFileCreditTO> filesView = new ArrayList<>();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Tuple> criteriaQuery = cb.createTupleQuery();
        Root<KCaseFileCredDO> root = criteriaQuery.from(KCaseFileCredDO.class);
        Join<KCaseFileCredDO, KCaseFileContentDO> joinItem = root.join("idFileContent", JoinType.INNER);
        Join<KCaseFileCredDO, CCaseFileStatusDO> joinItemStatus = root.join("idCaseFileStatusMort", JoinType.INNER);
        Join<KCaseFileCredDO, CCaseFileStatusDO> joinItemTypeMort= root.join("idCaseFileTypeMort", JoinType.INNER);

        criteriaQuery.multiselect(root.get("idCaseFileCred"),root.get("idDocErp"),root.get("nameDocErp"),
                joinItem.get("idFileContent"),joinItem.get("contentType"),joinItem.get("nameFile"),
                joinItemStatus.get("idCaseFileStatusMort"),joinItemStatus.get("description"),
                joinItemTypeMort.get("idCaseFileTypeMort"),joinItemTypeMort.get("description"),root.get("referencia"));

        List<Predicate> condiciones = new ArrayList();
        condiciones.add(cb.equal(root.get("idCredit"),new KCreditDO(1)));
        condiciones.add(cb.equal(root.get("active"), Boolean.TRUE));
        Optional.ofNullable(fileCreditFilterTO.getReference()).map(refe->condiciones.add(cb.equal(root.get("idCaseFileCred"),refe)));
        Optional.ofNullable(fileCreditFilterTO.getDocument()).map(refe->condiciones.add(cb.equal(root.get("idDocErp"),refe)));
        Optional.ofNullable(fileCreditFilterTO.getStatus()).
                map(refe->condiciones.add(cb.equal(root.get("idCaseFileStatusMort"),new CCaseFileStatusDO(refe)))
                );
        Optional.ofNullable(fileCreditFilterTO.getType()).map(refe->condiciones.add(cb.equal(root.get("idCaseFileTypeMort"),new CCaseFileTypeDO(refe))));
        criteriaQuery.where(condiciones.toArray(new Predicate[condiciones.size()]));
        criteriaQuery.orderBy(cb.desc(root.get("idCaseFileCred")));

        TypedQuery<Tuple> typeQ = em.createQuery(criteriaQuery);

        List<Tuple> filesDO = (List<Tuple>) typeQ.getResultList();
        filesDO.forEach(tuple->{
            ViewFileCreditTO viewFile = new ViewFileCreditTO();
            viewFile.setIdFile(tuple.get(0,Integer.class));
            viewFile.setReference(tuple.get(10,Integer.class).toString());
            viewFile.setNameDoc(tuple.get(2,String.class));
            viewFile.setIdFileContent(tuple.get(3,Integer.class));
            if(tuple.get(1,String.class)!=null){
                viewFile.setDoc(new CatalogoTO(tuple.get(1,String.class),tuple.get(2,String.class)));
                viewFile.setNameDoc(tuple.get(2,String.class));
            }
            viewFile.setStatus(new CatalogoTO(tuple.get(6,Integer.class).toString(),tuple.get(7,String.class)));
            viewFile.setType(new CatalogoTO(tuple.get(8,Integer.class).toString(),tuple.get(9,String.class)));
            String contentTYpe= tuple.get(4,String.class);
            String nameFile = tuple.get(5,String.class);
            viewFile.setNameExtension(nameFile.substring(nameFile.indexOf(".")));
            viewFile.setMediaType(contentTYpe);
            filesView.add(viewFile);
        });

    }

}
