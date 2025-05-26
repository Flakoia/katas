# Bienvenue dans l’équipe de l’auberge Gilded Rose !

Nous sommes un petit établissement réputé, situé au cœur d’une ville animée, tenu par la sympathique aubergiste Allison.
Nous achetons et vendons des produits rares… qui, hélas, perdent en qualité au fil du temps.

Nous utilisons un système automatisé pour mettre à jour notre inventaire chaque nuit.
Ce système a été codé par un certain Leeroy – un développeur aussi rugueux qu'efficace – avant de partir vivre d’autres aventures.
Il a laissé derrière lui un code peu lisible, sans tests, rigide et dangereux à modifier.

Vous héritez de ce système, et votre mission est double :

- Comprendre et refactorer le code existant pour le rendre testable, maintenable, compréhensible.
- Ajouter une nouvelle fonctionnalité : la gestion des objets **« Conjured »** (conjugués), qui se dégradent deux fois plus vite que les objets normaux.

⚠️ **Mais attention** :
Ne touchez surtout pas à la classe `Item` ni à la propriété `Items` !
Elles appartiennent à un gobelin dans un coin du bureau, qui refuse tout principe de code partagé.
Si vous les modifiez, il entre en rage et vous *one-shot* sur-le-champ.
(Heureusement, vous pouvez faire du code autour…)

---

## 📚 Règles métier de l’inventaire

Chaque objet a deux attributs :

- `SellIn` : nombre de jours restants avant qu’il ne doive être vendu
- `Quality` : valeur qualitative de l’objet

Chaque nuit, le système décrémente ces deux valeurs… mais pas toujours de la même manière :

- La qualité ne descend jamais en dessous de 0.
- Une fois la date de vente passée (`SellIn < 0`), la qualité diminue **deux fois plus vite**.
- Les objets **« Aged Brie »** voient leur qualité **augmenter** avec le temps.
- La qualité **ne dépasse jamais 50** (sauf pour **Sulfuras**).
- **« Sulfuras »**, objet légendaire, **ne se vend jamais** et **sa qualité reste constante (80)**.
- **« Backstage passes »** voient leur qualité **augmenter à l’approche du concert** :
    - +2 à 10 jours ou moins
    - +3 à 5 jours ou moins
    - **tombe à 0 après le concert**
- **« Conjured »** : perdent **deux fois plus vite** en qualité que les objets normaux.

---

## 🛠 Déroulé proposé de l’exercice

1. **Présentation du scénario**
   Explication des règles métier, lecture du code fourni.

2. **Constat**
   Il n’y a **aucun test automatisé**. Vous en ajoutez un premier, mais il est **peu satisfaisant**.

3. **Ajout de tests pour sécuriser le refactoring**, en s’appuyant sur :
    - ✅ *Approval Testing*
    - 🧬 *Mutation Testing* (tests de robustesse)

4. **Ajout de la nouvelle règle pour les objets `Conjured`**
