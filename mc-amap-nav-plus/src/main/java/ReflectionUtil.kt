package uts.sdk.modules.mcAmapNavPlus

/**
 * Utility class for accessing protected fields using Java reflection.
 */
object ReflectionUtil {
	fun <T> getProtectedField(
		obj: Any,
		fieldName: String,
	): T {
		val clazz = obj.javaClass
		val field = getDeclaredField(clazz, fieldName)
		field.isAccessible = true
		@Suppress("UNCHECKED_CAST")
		return field.get(obj) as T
	}

	fun setProtectedField(
		obj: Any,
		fieldName: String,
		value: Any?,
	) {
		val clazz = obj.javaClass
		val field = getDeclaredField(clazz, fieldName)
		field.isAccessible = true
		field.set(obj, value)
	}

	fun <T> invokeStaticMethod(
		className: String,
		methodName: String,
		parameterTypes: Array<Class<*>> = emptyArray(),
		args: Array<Any?> = emptyArray(),
	): T {
		val clazz = Class.forName(className)
		val method = clazz.getDeclaredMethod(methodName, *parameterTypes)
		method.isAccessible = true
		@Suppress("UNCHECKED_CAST")
		return method.invoke(null, *args) as T
	}

	fun <T> invokeStaticMethod(
		clazz: Class<*>,
		methodName: String,
		parameterTypes: Array<Class<*>> = emptyArray(),
		args: Array<Any?> = emptyArray(),
	): T {
		val method = clazz.getDeclaredMethod(methodName, *parameterTypes)
		method.isAccessible = true
		@Suppress("UNCHECKED_CAST")
		return method.invoke(null, *args) as T
	}

	private fun getDeclaredField(
		clazz: Class<*>,
		fieldName: String,
	): java.lang.reflect.Field {
		var currentClass: Class<*>? = clazz
		
		while (currentClass != null) {
			try {
				return currentClass.getDeclaredField(fieldName)
			} catch (e: NoSuchFieldException) {
				// Field not found in current class, check the superclass
				currentClass = currentClass.superclass
			}
		}
		
		throw NoSuchFieldException("Field '$fieldName' not found in class ${clazz.name} or any of its superclasses")
	}
}
