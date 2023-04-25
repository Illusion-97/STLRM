package dwn.slrm.generic;

import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class GenericTools {
    public static <T> T getEntity(Class<?> clazz, int genericInterfacePosition, int genericClassPosition) {
        try {
            // clazz = AbstractCrudServiceImpl<Entity,Dto> implements IAbstractCrudService<Entity,Dto>,Serializable
            // genericInterfacePosition = 0
            // genericClassPosition = 0
            Type[] interfaces = clazz.getGenericInterfaces(); // [IAbstractCrudService<Entity,Dto>,Serializable]
            ParameterizedType type = (ParameterizedType) interfaces[genericInterfacePosition]; // IAbstractCrudService<Entity,Dto>
            Type[] classes = type.getActualTypeArguments(); // [ActualEntity,ActualDto]
            Type genericType = classes[genericClassPosition]; // ActualEntity
            String genericClassName = genericType.getTypeName(); // ActualEntityName
            Class<?> genericClass = Class.forName(genericClassName); // ActualEntityClass
            Constructor<?> actualEntityConstructor = genericClass.getDeclaredConstructor();
            // actualEntityConstructor.setAccessible(true); Attention : Rends public un attribut privé ou protégé jusqu'à mention contraire ou redémarrage
            Object newEntity = actualEntityConstructor.newInstance();
            return (T) newEntity;
        } catch (Exception exception) {
            // Exception -> Doit obligatoirement être gérée
            // RuntimeException -> Fonctionne comme une exception, mais n'est pas obligatoirement gérée dans le code
            throw new RuntimeException(exception.getMessage());
        }
    }
}
