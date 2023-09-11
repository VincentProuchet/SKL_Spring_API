/**
 * les services de ce package ne sont que des interfaces
 * qui sont implementées dans le sous-package implementation
 *
 * pour faire simple le service est dédier à faire tous les contrôle necessaires
 * entre les requêtes utilisateurs et les repository
 * si vous devez faire des controle sur des dates ou des regex c'est dans un service.
 *
 * si cette couche d'asbtraction peux sembler éxagérée elle est en réalité très pratique
 * car elle permet de modifier l'implémentation
 * sans avoir à controler que le reste du code peux utiliser le service.
 * et en plus l'interface est utilisée pour l'autowiring des services
 * dans les controleurs et les @beans de configuration
 *
 *  @author VincentProuchet
 */
package skl.com.services;